package com.example.shop.payments;

public class PayPal implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " by PayPal");
    }
}
