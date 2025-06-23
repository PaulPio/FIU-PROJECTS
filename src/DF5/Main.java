package src.DF5;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try {
            String filename = "hello.txt";
            Scanner in = new Scanner(new File(filename));
            String input = in.next();
            int value = Integer.parseInt(input);
        } catch (FileNotFoundException exception) {
            System.out.println("File not found.");
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (NumberFormatException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
