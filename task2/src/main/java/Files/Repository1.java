package Files;

import Model.Shape;

import java.util.Stack;

public class Repository1 implements IRepository {
    private Stack<Shape> _shapes;
    public Repository1(){
        _shapes = new Stack<>();
    }
    @Override
    public void addPlusShape(Shape shape){
        _shapes.push(shape);
    }
    @Override
    public void pathShape(Stack<Shape> stack) {_shapes = stack;}
    @Override
    public void delShape(){
        if (_shapes.empty()) return;
        _shapes.pop();
    }
    @Override
    public Stack<Shape> getStackShapes() {
        return this._shapes;
    }
}
