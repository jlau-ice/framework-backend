package com.carbon.test.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping()
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

    @PostMapping("/file")
    public MultipartFile file(MultipartFile file) {
        try {
            file.getInputStream();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}


