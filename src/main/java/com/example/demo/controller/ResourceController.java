package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Value("classpath:banner.txt")
    private Resource resource;

    @GetMapping()
    public String resource() throws IOException {
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(this.resource.getInputStream(), StandardCharsets.UTF_8)
                )
        ) {
            reader.lines().forEachOrdered(System.out::println);
        }

        return "value";
    }

}
