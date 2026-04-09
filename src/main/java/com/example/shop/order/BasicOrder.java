package com.example.shop.order;

import com.example.shop.model.Product;

public class BasicOrder implements OrderService {
    private Product product;

    public BasicOrder(Product product) {
        this.product = product;
    }

    @Override
    public String getDescription() {
        return product.getName();
    }

    @Override
    public double getCost() {
        return product.getPrice();
    }
}
