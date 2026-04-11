package com.example.shop.order;

import com.example.shop.model.Book;
import com.example.shop.model.Electronics;
import com.example.shop.model.Furniture;
import com.example.shop.model.Product;

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
    public String getDescription() {
        String detail = "";
        if (product instanceof Book b) detail = b.getAuthor();
        else if (product instanceof Electronics e) detail = e.getBrand();
        else if (product instanceof Furniture f) detail = f.getMaterial();
        return product.getCategory() + " | " + detail;
    }
}
