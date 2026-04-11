package com.example.shop.model;

public class Furniture implements Product {
    private String name;
    private double price;
    private int quantity;
    private String material;

    public Furniture(String name, double price, int quantity, String material) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.material = material;
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
        return ProductCategory.FURNITURE;
    }

    @Override
    public int getQuantity() { return quantity; }

    public String getMaterial() {
        return material;
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
        return "Furniture{name='" + name + "', price=" + price + ", material='" + material + "'}";
    }
}
