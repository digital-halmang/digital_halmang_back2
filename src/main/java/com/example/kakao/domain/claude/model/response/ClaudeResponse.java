package com.example.kakao.domain.claude.model.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ClaudeResponse {
    private String id;
    private List<ContentItem> content;
    private String role;
    private String model;
    private String stop_reason;
    private String type;
    private Usage usage;
}
