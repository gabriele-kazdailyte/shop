package com.example.shop.order;

import com.example.shop.model.*;

public class BasicOrder implements OrderService {
    private Product product;

    public BasicOrder(Product product) {
        this.product = product;
    }

    @Override
    public String getName() { return product.getName(); }

    @Override
    public String getExtras() {
        return "None";
    }

    @Override
    public double getCost() {
        return product.getPrice();
    }

    @Override
    public double getPrice() {
        return product.getPrice();
    }

    @Override
    public ProductCategory getCategory() {
        return product.getCategory();
    }

    @Override
    public String getDetail() {
        if (product instanceof Book b) return b.getAuthor();
        if (product instanceof Electronics e) return e.getBrand();
        if (product instanceof Furniture f) return f.getMaterial();
        return "";
    }

    @Override
    public String getDescription() {
        String detail = "";
        if (product instanceof Book b) detail = b.getAuthor();
        else if (product instanceof Electronics e) detail = e.getBrand();
        else if (product instanceof Furniture f) detail = f.getMaterial();
        return product.getCategory() + " | " + detail;
    }
}
