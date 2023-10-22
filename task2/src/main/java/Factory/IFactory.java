package Factory;

import Model.Shape;
import javafx.scene.paint.Color;

public interface IFactory {
    Shape createShape(String name);
    public Shape shapeToFile(int x, int y, Color color, String type);
}
