package com.example.shop.singleton;

import com.example.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private static Inventory instance;
    private List<Product> products;

    private Inventory() {
        products = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }
}
