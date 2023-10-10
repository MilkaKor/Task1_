package Controller;

import com.example.task2.Shape;
import com.example.task2.ShapeFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Task2Controller implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private TextField field;
    @FXML
    private Label label;
    private Shape shape;
    public static void initializeHandlers(Task2Controller controller){
        controller.canvas.setOnMouseClicked(controller::shapeHandler);
    }
    private void shapeHandler(MouseEvent event){
        if(!field.getText().isEmpty()){
            var nameShape = field.getText();
            shape = new ShapeFactory().createShape(nameShape);
            if(shape == null){
                warningMessage("Неправильное название фигуры");
            }
            else{
                GraphicsContext gc = canvas.getGraphicsContext2D();
                shape.setX(event.getX());
                shape.setY(event.getY());
                shape.draw(gc);
                label.setText(shape.discriptor());
            }
        }
        else{
            warningMessage("Фигура:");
        }
    }
    private void warningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Task2Controller.initializeHandlers(this);
    }
}