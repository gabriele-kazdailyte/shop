package com.example.shop.model;

import com.example.shop.factory.ProductCategory;

public class Furniture implements Product {
    private String name;
    private double price;

    public Furniture(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public ProductCategory getCategory() {
        return ProductCategory.FURNITURE;
    }
}
