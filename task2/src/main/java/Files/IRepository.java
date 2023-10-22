package Files;

import Model.Shape;

import java.util.Stack;

public interface IRepository {
    public void addPlusShape(Shape shape);
    public void delShape();
    public void pathShape(Stack<Shape> stack);
    public Stack<Shape> getStackShapes();
}
