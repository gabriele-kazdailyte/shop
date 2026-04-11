package com.example.shop;

import com.example.shop.order.OrderService;
import com.example.shop.order.ShoppingCart;
import com.example.shop.payments.BankTransfer;
import com.example.shop.payments.CreditCard;
import com.example.shop.payments.PayPal;
import com.example.shop.payments.PaymentStrategy;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CartController {
    @FXML
    private TableView<Map.Entry<OrderService, Integer>> cartTable;

    @FXML
    private TableColumn<Map.Entry<OrderService, Integer>, String> itemColumn;

    @FXML
    private TableColumn<Map.Entry<OrderService, Integer>, Integer> amountColumn;

    @FXML
    private TableColumn<Map.Entry<OrderService, Integer>, String> priceColumn;

    @FXML
    private TableColumn<Map.Entry<OrderService, Integer>, String> descriptionColumn;

    @FXML
    private TableColumn<Map.Entry<OrderService, Integer>, String> extraColumn;

    @FXML
    private Button goToStoreButton;

    @FXML
    private ComboBox<String> paymentTypeBox;

    @FXML
    private Label totalPrice;

    @FXML
    private Label endMessage;

    @FXML
    private Button completePaymentButton;

    public void initialize() {
        paymentTypeBox.getItems().addAll("Credit Card", "PayPal", "Bank Transfer");

        itemColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getKey().getName()));

        amountColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(
                        data.getValue().getValue()));

        priceColumn.setCellValueFactory(data -> {
            double cost = data.getValue().getKey().getCost() * data.getValue().getValue();
            String formatted = String.format("%.2f", cost);
            return new javafx.beans.property.SimpleStringProperty(formatted);
        });

        descriptionColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getKey().getDescription()));

        extraColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        data.getValue().getKey().getExtras()));

        refreshCart();
    }

    private void refreshCart() {
        cartTable.getItems().clear();
        LinkedHashMap<OrderService, Integer> items = ShoppingCart.getInstance().getItems();
        cartTable.getItems().addAll(items.entrySet());
        totalPrice.setText(String.format("%.2f", ShoppingCart.getInstance().getTotalCost()));
    }

    @FXML
    void completePaymentPressed(ActionEvent event) {
        String selected = paymentTypeBox.getValue();

        if (selected == null) {
            endMessage.setText("Please select a payment method!");
            return;
        }

        PaymentStrategy strategy = switch (selected) {
            case "Credit Card" -> new CreditCard(endMessage);
            case "PayPal" -> new PayPal(endMessage);
            case "Bank Transfer" -> new BankTransfer(endMessage);
            default -> null;
        };

        ShoppingCart.getInstance().setPaymentStrategy(strategy);

        endMessage.setText("Payment of €"
                + String.format("%.2f", ShoppingCart.getInstance().getTotalCost())
                + " completed via " + selected + "!");

        ShoppingCart.getInstance().checkout();


        refreshCart();
    }

    @FXML
    void goToStorePressed(ActionEvent event) {
        goToStoreButton.getScene().getWindow().hide();
    }

    @FXML
    void removeItemPressed(ActionEvent event) {
        

    }

}
