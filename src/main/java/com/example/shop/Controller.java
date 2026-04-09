package com.example.shop;

import com.example.shop.factory.ProductFactory;
import com.example.shop.model.Product;
import com.example.shop.model.ProductCategory;
import com.example.shop.observer.AdminLogger;
import com.example.shop.observer.UIObserver;
import com.example.shop.order.BasicOrder;
import com.example.shop.order.ExpressDelivery;
import com.example.shop.order.GiftWrapping;
import com.example.shop.order.OrderService;
import com.example.shop.inventory.Inventory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {


    private Inventory inventory = Inventory.getInstance();
    private UIObserver observer = new UIObserver();


    @FXML
    public void initialize() {
        inventory.registerObserver(observer);
        inventory.registerObserver(new AdminLogger());
    }

}
