package com.example.kakao.domain.claude.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Usage {
    private int input_tokens;
    private int output_tokens;
}
