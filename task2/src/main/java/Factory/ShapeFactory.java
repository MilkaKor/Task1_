package Factory;

import Model.Circle;
import Model.Rectangle;
import Model.Shape;
import Model.Square;
import javafx.scene.paint.Color;

public class ShapeFactory implements IFactory{
    @Override
    public Shape createShape(String name) {
        if (name.equals("Круг")) {
            return new Circle();
        } else if (name.equals("Квадрат")) {
            return new Square();
        } else if (name.equals("Треугольник")){
            return new Rectangle();
        } else
            return null;
    }

    @Override
    public Shape shapeToFile(int x, int y, Color color, String type){
        return switch (type) {
            case "Круг" -> new Circle(x,y,color);
            case "Квадрат" -> new Square(x,y,color);
            case "Треугольник" -> new Rectangle(x,y,color);
            default -> null;
        };
    }
}
