package com.example.shop.model;

public class Electronics implements Product {
    private String name;
    private double price;
    private int quantity;
    private String brand;

    public Electronics(String name, double price, int quantity, String brand) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
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
    public int getQuantity() { return quantity; }

    @Override
    public ProductCategory getCategory() {
        return ProductCategory.ELECTRONICS;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public void decreaseQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }

    @Override
    public void increaseQuantity() {
        quantity++;
    }

    public String toString() {
        return "Electronics{name='" + name + "', price=" + price + ", brand='" + brand + "'}";
    }
}
