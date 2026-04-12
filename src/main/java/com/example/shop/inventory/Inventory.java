package com.example.shop.inventory;

import com.example.shop.Controller;
import com.example.shop.model.Book;
import com.example.shop.model.Electronics;
import com.example.shop.model.Furniture;
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

    public void addMoreOfProduct(Product product) {
        for (Product existing : products) {
            if (existing.getName().equals(product.getName())
                    && existing.getCategory().equals(product.getCategory())
                    && existing.getPrice() == product.getPrice()
                    && getDetail(existing).equals(getDetail(product))) {
                existing.increaseQuantity(product.getQuantity());
                notifyObservers(existing);
                return;
            }
        }
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

    private String getDetail(Product p) {
        if (p instanceof Book b) return  b.getAuthor();
        if (p instanceof Electronics e) return e.getBrand();
        if (p instanceof Furniture f) return f.getMaterial();
        return "";
    }
}
