package com.example.shop.factory;

import com.example.shop.model.*;

public class ProductFactory {
    public static Product createProduct(ProductCategory category, String name, double price, int quantity, String detail) {
        return switch (category) {
            case BOOK -> new Book(name, price, quantity, detail);
            case ELECTRONICS -> new Electronics(name, price, quantity, detail);
            case FURNITURE -> new Furniture(name, price, quantity, detail);
        };
    }

}
