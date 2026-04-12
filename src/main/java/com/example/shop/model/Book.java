package com.example.shop.model;

public class Book implements Product {
    private String name;
    private double price;
    private int quantity;
    private String author;

    public Book(String name, double price, int quantity, String author) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
    public int getQuantity() {return quantity; }

    @Override
    public ProductCategory getCategory() {
        return ProductCategory.BOOK;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    public String toString() {
        return "Book{name='" + name + "', price=" + price + ", author='" + author + "'}";
    }

}
