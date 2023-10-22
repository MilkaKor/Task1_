package com.example.task2;

import Factory.ShapeFactory;
import Model.Shape;
import Files.FileSM;
import Files.Repository1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class Task2Controller implements Initializable {
    public Canvas sheet;
    public ColorPicker colorPicker;
    public Label infoShape;
    public Spinner<Integer> spinner;
    public TextField nameShape;
    private Shape shape;
    private ShapeFactory factory;
    private GraphicsContext context;
    @FXML
    private Repository1 stack_shapes;
    private FileSM fIleManager;
    private int initialValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        context = this.sheet.getGraphicsContext2D();
        factory = new ShapeFactory();
        fIleManager = new FileSM();
        stack_shapes = new Repository1();
        this.context.setFill(Color.ALICEBLUE);
        this.context.fillRect(0,0,sheet.getWidth(),sheet.getHeight());
        var valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5,30,initialValue);
        spinner.setValueFactory(valueFactory);
    }

    public void ClickMouse(MouseEvent mouseEvent) throws FileNotFoundException {
        double x = mouseEvent.getX(); double y = mouseEvent.getY();
        shape = factory.createShape(nameShape.getText());
        if (shape == null) {
            System.out.println("Такой фигуры не существует");
            return;
        }
        shape.setColor(this.colorPicker.getValue());
        shape.setX((int)x); shape.setY((int)y);
        stack_shapes.addPlusShape(shape);
        shape.drawShape(context);
    }
    public void clickFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extensionFilter);
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file == null) return;
        stack_shapes.pathShape(fIleManager.loadDataFromFile(file));
        initShapes();
    }

    public void clickButton(ActionEvent actionEvent) {
        stack_shapes.delShape();
        initShapes();
    }

    private void initShapes(){
        this.context.setFill(Color.ALICEBLUE);
        this.context.fillRect(0,0,sheet.getWidth(),sheet.getHeight());
        for (var item: stack_shapes.getStackShapes()) {
            item.drawShape(context);
        }
    }

    public void saveFileClick(ActionEvent actionEvent) throws FileNotFoundException {
        fIleManager.saveDataFile(stack_shapes.getStackShapes());
    }
}