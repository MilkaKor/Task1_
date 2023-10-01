module com.example.java2_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java2_ to javafx.fxml;
    exports com.example.java2_;
}