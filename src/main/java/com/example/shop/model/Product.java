package com.example.shop.model;

import com.example.shop.factory.ProductCategory;

public interface Product {
    String getName();
    double getPrice();
    ProductCategory getCategory();
}
