package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;

public interface IFileM<T> {
    public void saveDataFile(Stack<T> stack) throws FileNotFoundException;

    public Stack<T> loadDataFromFile(File file);
}