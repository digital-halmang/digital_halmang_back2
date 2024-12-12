package com.example.kakao.domain.claude.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class CardNews {

    private List<String> cardNews;
}
