package com.example.shop.order;

import com.example.shop.payments.PaymentStrategy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ShoppingCart {
    private LinkedHashMap<OrderService, Integer> items;
    private PaymentStrategy paymentStrategy;
    private static ShoppingCart instance;

    private ShoppingCart() {
        items = new LinkedHashMap<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(OrderService order) {
        for (OrderService existing : items.keySet()) {
            if (existing.getDescription().equals(order.getDescription())
                    && existing.getExtras().equals(order.getExtras())) {
                items.put(existing, items.get(existing) + 1);
                return;
            }
        }
        items.put(order, 1);
    }

    public void removeItem(OrderService order) {
        for (OrderService existing : items.keySet()) {
            if (existing.getDescription().equals(order.getDescription())
                    && existing.getExtras().equals(order.getExtras())) {
                int currentQty = items.get(existing);
                if (currentQty <= 1) {
                    items.remove(existing);
                } else {
                    items.put(existing, currentQty - 1);
                }
                return;
            }
        }
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public double getTotalCost() {
        return items.entrySet().stream()
                .mapToDouble(e -> e.getKey().getCost() * e.getValue())
                .sum();
    }

    public void checkout() {
        paymentStrategy.pay(getTotalCost());
        items.clear();
    }

    public LinkedHashMap<OrderService, Integer> getItems() {
        return items;
    }
}
