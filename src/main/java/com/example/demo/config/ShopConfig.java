package com.example.demo.config;

import com.example.demo.shop.Cashier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShopConfig {

    @Bean
    public Cashier cashier() {
        Cashier cashierNew = new Cashier();
        cashierNew.setFileName("checkout");
        cashierNew.setPath("/Users/jangjeonghun/cashier");

        return cashierNew;
    }
}
