package com.example.task2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {
    public Rectangle(){
        super("Прямоугольник", Color.ORANGERED, Color.VIOLET, 55, 55);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.getStrokeColor());
        gc.strokeRect(this.getX() - (this.getWidth()/2), this.getY() - (this.getHeight()/2), this.getWidth(), this.getHeight());
        gc.setFill(this.getFillColor());
        gc.fillRect(this.getX() - (this.getWidth()/2), this.getY() - (this.getHeight()/2), this.getWidth(), this.getHeight());
    }

    @Override
    public String discriptor() {
        return "Фигура: Прямоугольник: "+this.getHeight() + "x" + this.getWidth();
    }
}
