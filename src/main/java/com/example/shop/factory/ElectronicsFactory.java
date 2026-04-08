package com.example.shop.factory;

import com.example.shop.model.Electronics;
import com.example.shop.model.Product;

public class ElectronicsFactory {

    public Product createProduct(String name, double price) {
        return new Electronics(name, price);
    }
}
