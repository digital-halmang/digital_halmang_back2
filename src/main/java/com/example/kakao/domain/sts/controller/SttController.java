package com.example.kakao.domain.sts.controller;


import com.example.kakao.domain.claude.model.response.BlogPost;
import com.example.kakao.domain.claude.model.response.Caption;
import com.example.kakao.domain.claude.model.response.CardNews;
import com.example.kakao.domain.claude.service.ClaudeService;
import com.example.kakao.domain.sts.service.SttService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RequiredArgsConstructor
@RestController
public class SttController {

    private final ClaudeService service;
    private final SttService sttService;

    @PostMapping("/api/cardnews")
    public CardNews getCardNews(@RequestBody String text) {
        return service.getCardNews(text);
    }

    @PostMapping("/api/blog")
    public BlogPost getBlog(@RequestBody String text) {
        return service.getBlog(text);
    }

    @PostMapping("/api/caption")
    public Caption getCaption(@RequestBody String text) {
        return service.getCaption(text);
    }

    @PostMapping(value = "/api/audio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleAudioMessage(@RequestParam("audioFile") MultipartFile audioFile) throws IOException {
        return sttService.transcribe(audioFile, 44100);
    }
}
