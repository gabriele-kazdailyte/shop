package com.example.shop.factory;

import com.example.shop.model.Book;
import com.example.shop.model.Product;

public class BookFactory extends ProductFactory {

    public Product createProduct(String name, double price) {
        return new Book(name, price);
    }

}
