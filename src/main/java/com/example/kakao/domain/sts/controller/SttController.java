package com.example.kakao.domain.sts.controller;

import com.example.kakao.domain.claude.model.response.Contents;
import com.example.kakao.domain.claude.service.ClaudeService;
import com.example.kakao.domain.sts.service.SttService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class SttController {

    private final SttService sttService;
    private final ClaudeService service;

    @PostMapping(value = "/api/audio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Contents handleAudioMessage() throws IOException {
        System.out.println("@@@@@@");
        return service.getContents("떡볶이는 맛있어 내 최애 음식이야");



    }
}
