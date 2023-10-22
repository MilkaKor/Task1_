package Files;

import Factory.ShapeFactory;
import Model.Shape;
import javafx.scene.paint.Color;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Stack;

public class FileSM implements IFileM<Shape> {

    @Override
    public void saveDataFile(Stack<Shape> stack) throws FileNotFoundException {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Shapes_state" + LocalDate.now().toString() + ".txt");
             PrintStream printStream = new PrintStream(fileOutputStream)){
            for (var item: stack) {
                printStream.println(item.toString());
            }
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Stack<Shape> loadDataFromFile(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {

            Stack<Shape> shapes = new Stack<Shape>();
            ArrayList<String> items = new ArrayList<>();
            StringBuilder lines = new StringBuilder();

            int count;

            while ((count = inputStreamReader.read()) != -1){
                if ((char)count == '\n'){
                    items.add(lines.toString());
                    lines = new StringBuilder();
                }
                else lines.append((char) count);
            }

            for (var item: items) {
                shapes.push(this.setShapeHelper(item));
            }
            return shapes;
        }
        catch (Exception exception) {
            System.out.println(exception.toString());
        }
        return null;
    }

    private Shape setShapeHelper(String info){
        var args = info.split(" ");
        return new ShapeFactory().shapeToFile(Integer.parseInt(args[1]),Integer.parseInt(args[2]),
                Color.valueOf(args[3].replace('\r',' ').trim()), args[0]);
    }
}

