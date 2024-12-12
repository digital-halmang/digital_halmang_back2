package com.example.kakao.domain.claude.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ContentItem {
    private String text;
    private String type;
}
