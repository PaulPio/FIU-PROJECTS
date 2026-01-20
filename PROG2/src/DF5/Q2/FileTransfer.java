package src.DF5.Q2;

import java.io.*;
import java.util.*;

public class FileTransfer {
    // write the full path of the file in your intellij folder
    public static final String fileName = "src/DF5/Q2/input.txt";
    public static void main(String[] args){
        Scanner inputScanner = null;
        PrintWriter outputWriter = null;

        // First, read all lines from the file into an ArrayList in memory.
        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            inputScanner = new Scanner(file);
            while (inputScanner.hasNextLine()) {
                list.add(inputScanner.nextLine());
            }
        }catch (FileNotFoundException exp) {
            System.out.println("Fatal Error: cannot read from \"input.txt\"!");
            System.exit(1);
        } finally {
            // Close the scanner before trying to write to the file.
            if (inputScanner != null) {
                inputScanner.close();
            }
        }
        // Now, attempt to open the same file for writing.
        // This will erase the original content.
        try {
            outputWriter = new PrintWriter(fileName);
        } catch (Exception exp) {
            System.out.println("Fatal Error: cannot write into \"input.txt\"!");
            System.exit(2);
        }

        // Write the uppercase content from the list back into the file.
        for (int i = 0; i < list.size(); i++) {
            outputWriter.print(list.get(i).toUpperCase());
            // Add a newline for all but the very last line to preserve formatting.
            if (i != list.size() - 1) {
                outputWriter.println();
            }
        }
        outputWriter.close();
    }
}