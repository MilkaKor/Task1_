package com.example.task1;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class Task1Controller {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField textField;

    @FXML
    private Button ellipsButton;

    @FXML
    private Button rectangleButton;

    @FXML
    private Button triangleButton;

    @FXML
    private ColorPicker strokeColorPicker;

    @FXML
    private Label label;

    @FXML
    private TextField textField1;



    private Shape shape;
    @FXML
    private void drawShapesHandler(MouseEvent event){
        var gc= canvas.getGraphicsContext2D();
        shape.setX(event.getX());
        shape.setY(event.getY());
        shape.draw(gc);
        label.setText(shape.toString());
    }
    @FXML
    private void selectTriangleHandler(MouseEvent event){
        if (textField.getText().isEmpty() || textField1.getText().isEmpty())
            displayWarningMessage("Введите высоту и ширину фигуры!");
        else {
            shape = new Triangle(strokeColorPicker.getValue(),
                    colorPicker.getValue(),
                    Double.parseDouble(textField.getText()),
                    Double.parseDouble(textField1.getText()));
        }
    }
    @FXML
    private void selectRectangleHandler(MouseEvent event){
        if (textField.getText().isEmpty() || textField1.getText().isEmpty())
            displayWarningMessage("Введите высоту и ширину фигуры!");
        else {
            shape = new Rentangle(strokeColorPicker.getValue(),
                    colorPicker.getValue(),
                    Double.parseDouble(textField.getText()),
                    Double.parseDouble(textField1.getText()));

        }
    }
    @FXML
    private void selectEllipsHandler(MouseEvent event) {
        if (textField.getText().isEmpty() || textField1.getText().isEmpty())
            displayWarningMessage("Введите высоту и ширину фигуры!");
        else {
            shape = new Ellips(strokeColorPicker.getValue(),
                    colorPicker.getValue(),
                    Double.parseDouble(textField.getText()),
                    Double.parseDouble(textField1.getText()));
        }
    }
    private void displayWarningMessage(String text){
        var alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Сообщение");
        alert.setHeaderText("Предупреждение");
        alert.setContentText(text);
        alert.showAndWait();
    }
}