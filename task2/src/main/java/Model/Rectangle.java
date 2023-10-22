package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

    private final double length;
    private final double angle;

    public Rectangle(){
        super(20,20, Color.ALICEBLUE);
        angle = 0.45;
        length = 10;
    }

    public Rectangle(int x, int y, Color color) {
        super(x,y, color);
        angle = 0.45;
        length = 10;
    }
    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(super.getColor());
        context.fillPolygon(new double[]{super.getX(),getX()+ length*Math.tan(angle), getX() -length},new double[]{super.getY(),getY() -length,getY() -(length*Math.tan(angle))},3);
    }

    @Override
    public String toString(){
        return "Треугольник " + super.getX() + " " + super.getY() + " " + super.getColor().toString();
    }
}