package com.example.shop.observer;

import com.example.shop.model.Product;

public class AdminLogger implements ProductObserver {
    @Override
    public void update(Product product) {
        System.out.println("[ADMIN LOG] New product registered: "
                + product.getName()
                + " | Category: " + product.getCategory());
    }
}
