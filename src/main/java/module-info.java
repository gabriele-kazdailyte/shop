module com.example.shop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.shop to javafx.fxml;
    exports com.example.shop;
}