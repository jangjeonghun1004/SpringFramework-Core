package com.example.demo.service;

import org.springframework.stereotype.Component;

@Component
public class AspectServiceImpl implements AspectService {
    @Override
    public double add(double a, double b) {
        double result = a + b;
        return result;
    }

    @Override
    public double div(double a, double b) {
        double result = a / b;
        return result;
    }
}
