package com.example.kakao.domain.sts.controller;


import com.example.kakao.domain.claude.model.response.BlogPost;
import com.example.kakao.domain.claude.model.response.Caption;
import com.example.kakao.domain.claude.model.response.CardNews;
import com.example.kakao.domain.claude.service.ClaudeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class SttController {

    private final ClaudeService service;

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
}
