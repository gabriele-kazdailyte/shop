package com.example.shop;

import com.example.shop.factory.ProductFactory;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCategory;
import com.example.shop.observer.UIObserver;
import com.example.shop.singleton.Inventory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    private Inventory inventory = Inventory.getInstance();
    private UIObserver observer = new UIObserver();

    @FXML
    public void initialize() {
        inventory.registerObserver(observer);
    }

    @FXML
    protected void onHelloButtonClick() {
        Product product = ProductFactory.createProduct(ProductCategory.BOOK, "Book1", 9.99, "Author1");
        inventory.addProduct(product);

        System.out.println("Product added: " + product.toString() + "Notifications sent: " + inventory.getObserverCount());
    }
}
