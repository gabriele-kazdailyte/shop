package com.example.shop.payments;

import com.example.shop.order.ShoppingCart;
import javafx.scene.control.Label;

public class CreditCard implements PaymentStrategy {
    private Label endMessage;

    public CreditCard(Label endMessage) {
        this.endMessage = endMessage;
    }

    @Override
    public void pay(double amount) {
        endMessage.setText("Payment of €"
                + String.format("%.2f", ShoppingCart.getInstance().getTotalCost())
                + " completed via Credit Card");

    }
}
