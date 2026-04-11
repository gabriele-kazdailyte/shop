package com.example.shop;

import com.example.shop.factory.ProductFactory;
import com.example.shop.model.*;
import com.example.shop.observer.AdminLogger;
import com.example.shop.observer.UIObserver;
import com.example.shop.order.*;
import com.example.shop.inventory.Inventory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TableColumn<Product, Integer> amountColumn;

    @FXML
    private TableColumn<Product, String> descriptionColumn;

    @FXML
    private TableColumn<Product, String> nameColumn;

    @FXML
    private TableColumn<Product, Double> priceColumn;

    @FXML
    private TableView<Product> productTable;

    @FXML
    private Button addProduct;

    @FXML
    private Button removeProduct;

    @FXML
    private TextArea messagesArea;

    @FXML
    private CheckBox expressDelivery;

    @FXML
    private CheckBox giftWrapping;

    private Inventory inventory = Inventory.getInstance();


    @FXML
    public void initialize() {
        UIObserver observer = new UIObserver(messagesArea);
        inventory.registerObserver(observer);
        inventory.registerObserver(new AdminLogger());

        nameColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));

        priceColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPrice()));

        amountColumn.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getQuantity()));

        descriptionColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(
                        getDetail(data.getValue())));

        if (inventory.getProducts().isEmpty()) {
            exampleProducts();
            productTable.getItems().addAll(inventory.getProducts());
        }
    }

    public void exampleProducts () {
        inventory.addProduct(ProductFactory.createProduct(
                ProductCategory.BOOK, "Romeo and Juliet", 9.99, 40,"Shakespeare"));

        inventory.addProduct(ProductFactory.createProduct(
                ProductCategory.ELECTRONICS, "iPhone 15", 499.99, 20,"iPhone"));

        inventory.addProduct(ProductFactory.createProduct(
                ProductCategory.FURNITURE, "Chair", 59.99, 10,"Wood"));

    }

    private String getDetail(Product p) {
        if (p instanceof Book b) return p.getCategory() + " | " + b.getAuthor();
        if (p instanceof Electronics e) return p.getCategory() + " | " + e.getBrand();
        if (p instanceof Furniture f) return p.getCategory() + " | " + f.getMaterial();
        return "";
    }

    @FXML
    void addProductPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("add-product-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.showAndWait();

        AddProductController addProductController = loader.getController();
        Product product = addProductController.getCreatedProduct();

        if (product != null) {
            inventory.addProduct(product);
            productTable.getItems().add(product);
        }
    }

    @FXML
    void removeProductPressed(ActionEvent event) {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();

        if (selectedProduct == null) {
            return;
        }

        inventory.removeProduct(selectedProduct);
        productTable.getItems().remove(selectedProduct);
    }

    @FXML
    void addToCartPressed(ActionEvent event) {
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();

        OrderService order = new BasicOrder(selectedProduct);

        if (giftWrapping.isSelected()) {
            order = new GiftWrapping(order);
        }
        if (expressDelivery.isSelected()) {
            order = new ExpressDelivery(order);
        }

        if (selectedProduct.getQuantity() == 0) {
            messagesArea.appendText(selectedProduct.getName() + " is out of stock!\n");
            return;
        }

        ShoppingCart.getInstance().addItem(order);

        selectedProduct.decreaseQuantity();
        productTable.refresh();

        messagesArea.appendText("Added to cart: " + order.getDescription()
                + " | €" + order.getCost() + "\n");

        giftWrapping.setSelected(false);
        expressDelivery.setSelected(false);
    }

    @FXML
    void goToCartPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cart-view.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Your Cart");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
