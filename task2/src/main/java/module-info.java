module com.example.task2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.task2 to javafx.fxml;
    exports com.example.task2;
    exports Controller;
    opens Controller to javafx.fxml;
}