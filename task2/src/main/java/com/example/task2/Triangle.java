package com.example.task2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape{
    public Triangle(){
        super("Треугольник", Color.HOTPINK, Color.PINK, 70, 70);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.getStrokeColor());
        gc.strokePolygon(new double[] {getX(), getX() - (getWidth()/2), getX() + (getWidth()/2)}, new double[] {getY() - (getHeight()/2), getY() + (getHeight()/2), getY() + (getHeight()/2)}, 3);
        gc.setFill(this.getFillColor());
        gc.fillPolygon(new double[] {getX(), getX() - (getWidth()/2), getX() + (getWidth()/2)}, new double[] {getY() - (getHeight()/2), getY() + (getHeight()/2), getY() + (getHeight()/2)}, 3);
    }

    @Override
    public String discriptor() {
        return "Фигура: Треугольник: "+this.getHeight() + "x" + this.getWidth();
    }
}
