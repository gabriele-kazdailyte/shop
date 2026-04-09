package com.example.shop.payments;

public class BankTransfer implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " by bank transfer");
    }
}
