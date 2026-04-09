package com.example.shop.observer;

import com.example.shop.model.Product;

public class UIObserver implements ProductObserver {
    @Override
    public void update(Product product) {

        System.out.println("Product: " + product + " has been added");
    }
}
