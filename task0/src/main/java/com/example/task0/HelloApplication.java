package com.example.task0;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        Button but1 = new Button();
        FlowPane panel = new FlowPane();
        HBox box1 = new HBox();
        HBox box2 = new HBox();
        HBox box3 = new HBox();
        Button but2 = new Button();
        Button but3 = new Button();
        TextField txtField = new TextField();
        Label lab1 = new Label();
        Label lab2 = new Label();
        Label lab3 = new Label();
        box1.getChildren().add(but1);
        box1.getChildren().add(lab1);
        box2.getChildren().add(but2);
        box2.getChildren().add(lab2);
        panel.getChildren().add(txtField);
        box3.getChildren().add(but3);
        box3.getChildren().add(lab3);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}