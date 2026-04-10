package com.example.shop;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class CartController {
    @FXML
    private TableColumn<?, ?> amountColumn;

    @FXML
    private Button completePaymentButton;

    @FXML
    private TableColumn<?, ?> descriptionColumn;

    @FXML
    private Label endMessage;

    @FXML
    private TableColumn<?, ?> extraColumn;

    @FXML
    private TableColumn<?, ?> itemColumn;

    @FXML
    private ComboBox<?> paymentTypeBox;

    @FXML
    private TableColumn<?, ?> priceColumn;

    @FXML
    private Label totalPrice;

    @FXML
    void completePaymentPressed(ActionEvent event) {

    }

}
