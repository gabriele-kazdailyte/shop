package com.example.shop;

import com.example.shop.factory.ProductFactory;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCategory;
import com.example.shop.singleton.Inventory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        Inventory inventory = Inventory.getInstance();

        Product product = ProductFactory.createProduct(ProductCategory.BOOK, "Book1", 9.99, "Author1");
        inventory.addProduct(product);

        System.out.println("Product added: " + product.toString());
    }
}
