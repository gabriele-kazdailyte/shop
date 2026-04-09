package com.example.shop.observer;

import com.example.shop.model.Product;

public interface ProductObserver {
    void update(Product product);
}
