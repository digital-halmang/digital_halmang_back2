package com.example.kakao.domain.sts.controller;


import com.example.kakao.domain.claude.model.response.Contents;
import com.example.kakao.domain.claude.service.ClaudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class SttController {

    private final ClaudeService service;

   @GetMapping("/aa")
    public Contents handleAudioMessage() throws ExecutionException, InterruptedException {
        System.out.println("@@@@@@");
        return service.getContents("떡볶이는 맛있어 내 최애 음식이야");
    }
}
