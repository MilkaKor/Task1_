package com.example.task6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ResourceBundle;

public class Controller6 implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    Canvas canvas;
    @FXML
    ColorPicker colorPicker, outlineColor;
    @FXML
    TextField widthInput, heightInput, sides_input;
    @FXML
    ListView listview;

    Shape shape;
    int current_shape = 0;
    Deque<Shape> figures = new ArrayDeque<Shape>();
    ObservableList<Shape> content;

    public void initialize(URL location, ResourceBundle resources) {

        Ellipse ellipse = new Ellipse();

        Rectangle rectangle = new Rectangle();

        Angle angle = new Angle();

        Triangle triangle = new Triangle();

        content = FXCollections.observableArrayList(ellipse, angle, rectangle, triangle);

        listview.setItems(content);

        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }

    @FXML
    protected void onHelloButtonClick() {
        current_shape = 1;
    }

    @FXML
    protected void DrawEx2() {
        current_shape = 0;
    }

    @FXML
    protected void onMouseClicked(MouseEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();

        int index = listview.getSelectionModel().getSelectedIndex();
        Shape shape = (Shape) content.get(index).clone();
        shape.setColor(colorPicker.getValue());
        shape.setWH(Integer.parseInt(widthInput.getText()), Integer.parseInt(heightInput.getText()));
        shape.setXY(event.getX(), event.getY());
        shape.setBorder(outlineColor.getValue(), 5);
        shape.draw(gc);

        figures.add(shape);

        System.out.println(figures.toString());
    }

    @FXML
    protected void CancelDraw() {
        figures.pollLast();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Shape sh :
                figures) {
            sh.draw(gc);
        }
    }
}


