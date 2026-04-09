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
        inventory.registerObserver(new AdminLogger());
    }

    @FXML
    protected void onHelloButtonClick() {
        Product product = ProductFactory.createProduct(ProductCategory.BOOK, "Book1", 9.99, "Author1");
        inventory.addProduct(product);

        System.out.println("Notifications sent: " + inventory.getObserverCount());

        OrderService basicOrder = new BasicOrder(product);
        System.out.println("Basic order:");
        System.out.println("Description: " + basicOrder.getDescription());
        System.out.println("Cost: " + basicOrder.getCost());

        OrderService giftOrder = new GiftWrapping(basicOrder);
        System.out.println("\nOrder with gift wrapping:");
        System.out.println("Description: " + giftOrder.getDescription());
        System.out.println("Cost: " + giftOrder.getCost());

        OrderService expressOrder = new ExpressDelivery(basicOrder);
        System.out.println("\nOrder with express delivery:");
        System.out.println("Description: " + expressOrder.getDescription());
        System.out.println("Cost: " + expressOrder.getCost());

        OrderService fullOrder = new ExpressDelivery(new GiftWrapping(new BasicOrder(product)));
        System.out.println("\nOrder with gift wrapping and express delivery:");
        System.out.println("Description: " + fullOrder.getDescription());
        System.out.println("Cost: " + fullOrder.getCost());
    }
}
