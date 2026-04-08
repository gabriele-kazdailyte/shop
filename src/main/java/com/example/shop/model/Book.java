package com.example.shop.model;

public class Book implements Product {
    private String name;
    private double price;

    public Book(String name, double price) {
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
        return ProductCategory.BOOK;
    }

}
