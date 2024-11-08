package com.example.demo.shop;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
@Lazy
public class ShoppingCart {
    private List<String> items = new ArrayList<>();

    public void addItem(String itemName) {
        this.items.add(itemName);
    }

    public List<String> getItems() {
        return this.items;
    }

}
