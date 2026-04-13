package com.example.shop.order;

import com.example.shop.model.ProductCategory;

public interface OrderService {
    String getExtras();
    double getCost();
    double getPrice();
    ProductCategory getCategory();
    String getName();
    String getDetail();
    String getDescription();

}
