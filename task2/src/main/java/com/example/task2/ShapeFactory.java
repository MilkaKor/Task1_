package com.example.task2;

public class ShapeFactory {
    public Shape createShape(String name) {
        return switch (name) {
            case "Круг" -> new Circle();
            case "Прямоугольник" -> new Rectangle();
            case "Треугольник" -> new Triangle();
            default -> null;
        };
    }
}
