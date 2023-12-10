package com.example.task6;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape
{
    public Rectangle(Color color, double width, double height) {
        super(color);
        w = width;
        h = height;
    }
    public Rectangle() {
        super(Color.WHITE);
        w = 0;
        h = 0;
    }
    public Rectangle(Color color, double x, double y, double width, double height) {
        super(color);
        w = width;
        h = height;
        this.x = x;
        this.y = y;
    }

    @Override
    public double area()
    {
        return h*w;
    }
    @Override
    public void draw(GraphicsContext gc)
    {
        gc.setFill(color);
        gc.fillRect(x,y,w,h);
        if(outline_size != 0)
        {
            gc.setStroke(outline);
            gc.setLineWidth(outline_size);
            gc.strokeRect(x,y,w,h);
        }
    }

    @Override
    void setBorder(Color color, double size) {
        outline_size = size;
        outline = color;
    }

    @Override
    public String toString() {
        return "Прямоугольник";
    }
}

