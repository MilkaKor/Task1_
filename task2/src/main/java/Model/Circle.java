package Model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape  {
    private final Double height;
    public Circle(int x, int y, Color color, Double height, Double width){
        super(x, y, color);
        this.height = height;
    }

    public Circle(){
        super(20,20,Color.AQUA); this.height = 20.0;
    }

    public Circle(int x, int y, Color color){
        super(x, y, color);this.height = 20.0;
    }

    @Override
    public void drawShape(GraphicsContext context) {
        context.setFill(getColor());
        context.fillOval(super.getX() ,super.getY(),this.height, this.height);
    }

    @Override
    public String toString(){
        return "Круг " + super.getX() + " " + super.getY() + " " + super.getColor().toString();
    }
}
