package com.example.shop.inventory;

import com.example.shop.model.Product;
import com.example.shop.observer.ProductObserver;
import com.example.shop.observer.ProductSubject;

import java.util.ArrayList;
import java.util.List;

public class Inventory implements ProductSubject {

    private static Inventory instance;
    private List<Product> products;
    private List<ProductObserver> observers;

    private Inventory() {
        products = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
        notifyObservers(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void  removeAllProducts() {
        products.clear();
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void registerObserver(ProductObserver observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void removeObserver(ProductObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Product product) {
        observers.forEach(observer -> observer.update(product));
    }

    public int getObserverCount() {
        return observers.size();
    }
}
