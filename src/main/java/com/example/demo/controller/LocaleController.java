package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/locale")
public class LocaleController {
    private final MessageSource messageSource;

    @Autowired
    public LocaleController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping()
    public String hello() {
        Locale locale = Locale.forLanguageTag("ko");

        //return messageSource.getMessage("hello", null, locale);
        return this.messageSource.getMessage("dynamic", new Object[] {"정훈", new Date()}, locale);
    }

}
