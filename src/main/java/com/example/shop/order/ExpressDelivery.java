package com.example.shop.order;

public class ExpressDelivery extends OrderDecorator {
    private static final double EXP_DEL_COST = 3.99;

    public ExpressDelivery(OrderService orderService) {
        super(orderService);
    }

    @Override
    public String getName() {
        return orderService.getName();
    }

    @Override
    public String getExtras() {
        String existing = orderService.getExtras();
        return existing.equals("None") ? "Express Delivery" : existing + ", Express Delivery";
    }

    @Override
    public double getCost() {
        return orderService.getCost() + EXP_DEL_COST;
    }
}
