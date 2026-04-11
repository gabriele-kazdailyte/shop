package com.example.shop.payments;

import com.example.shop.order.ShoppingCart;
import javafx.scene.control.Label;

public class BankTransfer implements PaymentStrategy {
    private Label endMessage;

    public BankTransfer(Label endMessage) {
        this.endMessage = endMessage;
    }

    @Override
    public void pay(double amount) {
        endMessage.setText("Payment of €"
                + String.format("%.2f", ShoppingCart.getInstance().getTotalCost())
                + " completed via Bank Transfer");

    }
}
