package com.example.kakao.domain.sts.controller;

import com.example.kakao.domain.sts.service.SttService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class SttController {

    private final SttService sttService;

    @PostMapping(value = "/audio", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleAudioMessage(@RequestParam("audioFile") MultipartFile audioFile) throws IOException {
        return sttService.transcribe(audioFile, 44100);

    }
}
