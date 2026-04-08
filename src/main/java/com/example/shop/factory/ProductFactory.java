package com.example.shop.factory;

import com.example.shop.model.*;

public class ProductFactory {
    public static Product createProduct(String name, double price, ProductCategory category) {
        return switch (category) {
            case BOOK -> new Book(name, price);
            case ELECTRONICS -> new Electronics(name, price);
            case FURNITURE -> new Furniture(name, price);
        };
    }

}
