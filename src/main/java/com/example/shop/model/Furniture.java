package com.example.shop.model;

public class Furniture implements Product {
    private String name;
    private double price;
    private String material;

    public Furniture(String name, double price, String material) {
        this.name = name;
        this.price = price;
        this.material = material;
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

    public String getMaterial() {
        return material;
    }
}
