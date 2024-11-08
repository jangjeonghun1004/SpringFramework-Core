package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/value")
public class ValueController {
    @Value("${spring.application.name:defaultValue}")
    private String propertyValue;

    @GetMapping()
    public String propertyValue() {
        System.out.println(this.propertyValue);

        return "value";
    }

}
