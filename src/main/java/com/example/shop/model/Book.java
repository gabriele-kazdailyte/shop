package com.example.shop.model;

public class Book implements Product {
    private String name;
    private double price;
    private String author;

    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public ProductCategory getCategory() {
        return ProductCategory.BOOK;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{name='" + name + "', price=" + price + ", author='" + author + "'}";
    }

}
