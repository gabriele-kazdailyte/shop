package com.example.shop.model;

public interface Product {
    String getName();
    double getPrice();
    ProductCategory getCategory();
    int getQuantity();
    void decreaseQuantity();
    void increaseQuantity(int amount);
}
