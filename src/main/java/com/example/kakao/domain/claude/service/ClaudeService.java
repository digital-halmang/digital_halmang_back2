package com.example.kakao.domain.claude.service;

import com.example.kakao.domain.claude.model.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.kakao.domain.claude.constant.ClaudePrompt.*;

@RequiredArgsConstructor
@Service
public class ClaudeService {

    private final RestTemplate restTemplate;

    @Value("${spring.ai.anthropic.api-key}")
    private String ANTHROPIC_API_KEY;
    private final String CLAUDE_API_URL = "https://api.anthropic.com/v1/messages";

    public CardNews getCardNews(String text) {
        List<String> card = askClaude(FIRST_PROMPT, text);
       return new CardNews(card);
    }

    public BlogPost getBlog(String text) {

        List<String> blog = askClaude(SECOND_PROMPT, text);
        return new BlogPost(blog);
    }

    public Caption getCaption(String text) {

        List<String> caption = askClaude(THIRD_PROMPT, text);
        return new Caption(caption);
    }

    public List<String> askClaude(String prompt, String text) {

        String format = String.format(prompt, text);
        // API 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", ANTHROPIC_API_KEY);
        headers.set("anthropic-version", "2023-06-01");
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 요청 바디 생성
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "claude-3-opus-20240229");
        requestBody.put("max_tokens", 1800);
        requestBody.put("messages", Collections.singletonList(
                Map.of("role", "user", "content", format)
        ));

        // HTTP 엔티티 생성
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            try {
                ResponseEntity<ClaudeResponse> response = restTemplate.exchange(
                        CLAUDE_API_URL,
                        HttpMethod.POST,
                        entity,
                        ClaudeResponse.class
                );

                // content 리스트에서 text만 추출
                List<String> collect = response.getBody().getContent().stream()
                        .filter(content -> "text".equals(content.getType()))
                        .map(ContentItem::getText)
                        .collect(Collectors.toList());

                return collect;
            } catch (Exception e) {
                throw new RuntimeException("Failed to get response from Claude API", e);
            }
        } finally {

        }
    }
    }
