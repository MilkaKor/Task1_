package com.example.task2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape{
    public Circle(){
        super("Круг", Color.PURPLE, Color.IVORY, 67, 75);
    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setLineWidth(5.0);
        gc.setStroke(this.getStrokeColor());
        gc.strokeOval(this.getX() - (this.getHeight()/2), this.getY() - (this.getWidth()/2), this.getHeight(), this.getWidth());
        gc.setFill(this.getFillColor());
        gc.fillOval(this.getX() - (this.getHeight()/2), this.getY() - (this.getWidth()/2), this.getHeight(), this.getWidth());
    }

    @Override
    public String discriptor() {
        return "Фигура: Круг: "+this.getHeight() + "x" + this.getWidth();
    }
}

