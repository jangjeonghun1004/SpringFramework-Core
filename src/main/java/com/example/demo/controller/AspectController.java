package com.example.demo.controller;

import com.example.demo.service.AspectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aspect")
public class AspectController {
    private final AspectService aspectService;

    @Autowired
    public AspectController(AspectService aspectService) {
        this.aspectService = aspectService;
    }


    @GetMapping("add")
    public double add(double a, double b) {
        return this.aspectService.add(a, b);
    }

    @GetMapping("div")
    public double div(double a, double b) {
        return this.aspectService.div(a, b);
    }

}
