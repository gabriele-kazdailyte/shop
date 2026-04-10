package com.example.shop.observer;

import com.example.shop.model.Product;
import javafx.scene.control.TextArea;

public class UIObserver implements ProductObserver {
    private TextArea messagesArea;

    public UIObserver(TextArea messagesArea) {
        this.messagesArea = messagesArea;
    }

    @Override
    public void update(Product product) {
        messagesArea.appendText("Product added: " + product.getName() + "\n");
    }
}
