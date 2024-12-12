package com.example.kakao.domain.sts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

import static com.example.kakao.domain.claude.constant.ClaudePrompt.FIRST_PROMPT;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @Value("${spring.ai.anthropic.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public ProxyController() {
        this.restTemplate = new RestTemplate();
    }

    @PostMapping("/claude/**")
    public ResponseEntity<String> proxyRequest(
            @RequestBody(required = false) String body,
            HttpServletRequest request) {

        String claudeUrl = "https://api.anthropic.com" +
                request.getRequestURI().replace("/proxy/claude", "");

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        headers.set("anthropic-version", "2023-06-01");
        headers.set("Content-Type", "application/json");

        // JSON을 파싱하고 content에 프롬프트 추가
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(body);
            String content = jsonNode.at("/messages/0/content").asText();
            ((ObjectNode) jsonNode.at("/messages/0")).put("content", String.format(FIRST_PROMPT, content));

            HttpEntity<String> httpEntity = new HttpEntity<>(mapper.writeValueAsString(jsonNode), headers);

            ResponseEntity<String> response = restTemplate.exchange(
                    claudeUrl,
                    HttpMethod.valueOf(request.getMethod()),
                    httpEntity,
                    String.class
            );

            return ResponseEntity
                    .status(response.getStatusCode())
                    .headers(response.getHeaders())
                    .body(response.getBody());
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body("Invalid JSON format");
        } catch (HttpClientErrorException e) {
            return ResponseEntity
                    .status(e.getStatusCode())
                    .body(e.getResponseBodyAsString());
        }

    }
}
