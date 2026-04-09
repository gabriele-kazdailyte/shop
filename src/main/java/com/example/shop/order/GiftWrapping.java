package com.example.shop.order;

public class GiftWrapping extends OrderDecorator {
    private static final double GIFT_WRAP_COST = 2.99;

    public GiftWrapping(OrderService orderService) {
        super(orderService);
    }

    @Override
    public String getDescription() {
        return orderService.getDescription() + " + Gift Wrapping";
    }

    @Override
    public double getCost() {
        return orderService.getCost() + GIFT_WRAP_COST;
    }
}
