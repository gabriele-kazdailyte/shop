package com.example.shop.factory;

import com.example.shop.model.Product;

public abstract class ProductFactory {
    public abstract Product createProduct(String name, double price);

    public void announceProduct(Product product) {
        System.out.println("New product added: " + product.getName() +
                " | Category: " + product.getCategory() +
                " | Price: " + product.getPrice());
    }
}
