package com.example.shop.order;

import com.example.shop.payments.PaymentStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<OrderService> items = new ArrayList<>();
    private PaymentStrategy paymentStrategy;

    public void addItem(OrderService order) {
        items.add(order);
    }

    public void removeItem(OrderService order) {
        items.remove(order);
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public double getTotalCost() {
        return items.stream()
                .mapToDouble(OrderService::getCost)
                .sum();
    }

    public void checkout() {
        paymentStrategy.pay(getTotalCost());
    }

    public List<OrderService> getItems() {
        return items;
    }

}
