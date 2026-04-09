package com.example.shop.order;

public abstract class OrderDecorator implements OrderService {
    protected OrderService orderService;

    public OrderDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String getDescription() {
        return orderService.getDescription();
    }

    @Override
    public double getCost() {
        return orderService.getCost();
    }
}
