package com.example.shop.observer;

import com.example.shop.model.Product;

public interface ProductSubject {
    void registerObserver(ProductObserver observer);
    void removeObserver(ProductObserver observer);
    void notifyObservers(Product product);
}
