package com.example.demo.controller;

import com.example.demo.shop.Cashier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/predestroy")
public class PreDestroyController {
    private final Cashier cashier;
    private final ConfigurableApplicationContext context;


    @Autowired
    public PreDestroyController(ConfigurableApplicationContext context, Cashier cashier) {
        this.cashier = cashier;
        this.context = context;
    }

    @GetMapping()
    public String callPreDestroy() throws Exception {
        this.cashier.checkout();
        this.context.close();
        return "value";
    }
}
