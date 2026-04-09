package com.example.shop.model;

public class Electronics implements Product {
    private String name;
    private double price;
    private String brand;

    public Electronics(String name, double price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
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
        return ProductCategory.ELECTRONICS;
    }

    public String getBrand() {
        return brand;
    }
}
