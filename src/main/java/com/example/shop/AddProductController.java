package com.example.shop;

import com.example.shop.factory.ProductFactory;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCategory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class AddProductController {
    private Product createdProduct;

    @FXML
    private TextField priceField;

    @FXML
    private Button cancelButton;

    @FXML
    private ComboBox<ProductCategory> categoryBox;

    @FXML
    private Button createButton;

    @FXML
    private TextField detailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField quantityField;

    @FXML
    private Label messagesLabel;

    @FXML
    public void initialize() {
            categoryBox.getItems().addAll(ProductCategory.values());
    }

    @FXML
    void cancelProduct(ActionEvent event) {
        cancelButton.getScene().getWindow().hide();
    }

    @FXML
    void createProduct(ActionEvent event) {
        String name = nameField.getText();

        if (name == null || name.isEmpty()) {
            messagesLabel.setText("Please input a name!");
            return;
        }

        String priceText = priceField.getText();
        if (priceText == null || priceText.isEmpty()) {
            messagesLabel.setText("Please input a price!");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceText);
        } catch (NumberFormatException e) {
            messagesLabel.setText("Please input a valid price!");
            return;
        }
        price = Math.round(price * 100.0) / 100.0;

        String quantityText = quantityField.getText();
        if (quantityText == null || quantityText.isEmpty()) {
            messagesLabel.setText("Please input a quantity!");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            messagesLabel.setText("Please input a valid quantity!");
            return;
        }

        ProductCategory category = categoryBox.getValue();

        if (category == null) {
            messagesLabel.setText("Please input a category!");
            return;
        }

        String detail = detailField.getText();

        createdProduct = ProductFactory.createProduct(category, name, price, quantity, detail);

        createButton.getScene().getWindow().hide();
    }

    public Product getCreatedProduct() {
        return createdProduct;
    }
}
