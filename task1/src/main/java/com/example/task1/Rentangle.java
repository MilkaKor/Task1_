package com.example.task1;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rentangle extends Shape {
    private final double height, width;

    public Rentangle(Color strokeColor, Color fillColor, double height, double width) {
        super(strokeColor, fillColor);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.strokeColor);
        gc.strokeRect(this.x - (width / 2), this.y - (height / 2), width, height);
        gc.setFill(this.fillColor);
        gc.fillRect(this.x - (width / 2), this.y - (height / 2), width, height);
    }

    @Override
    public String toString() {
        return "Выбранная фигура: Прямоугольник: Размеры: " + height + "x" + width;
    }
}