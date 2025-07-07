package src.DF5.Q1;
import java.util.*;
import java.io.*;
public class FileTransfer {
    // write the full path of the file in your intellij folder
    public static final String inputFileName = "src/DF5/Q1/input.txt";
    public static final String outputFileName = "src/DF5/Q1/output.txt";


    public static void main(String[] args) {
        Scanner inputScanner = null;
        PrintWriter outputWriter = null;

        try {
            // Create a File object representing the input file.
            File file = new File(inputFileName);
            // Initialize the Scanner to read from the input file.
            inputScanner = new Scanner(file);
            // Initialize the PrintWriter to write to the output file.
            outputWriter = new PrintWriter(outputFileName);
        } catch (FileNotFoundException exp) {
            // This block executes if the input file cannot be found.
            System.out.println("Fatal Error: cannot read from \"" + inputFileName + "\" or " +
                    "write into \"" + outputFileName + "\"!");
            // Exit the program with an error status.
            System.exit(1);
        }

        // Loop as long as there are more lines to read in the input file.
        while (inputScanner.hasNextLine()) {

            String line = inputScanner.nextLine();

            for (char c : line.toCharArray()) {
                // Write the uppercase version of the character to the output file.
                // %c is the format specifier for a single character.
                outputWriter.printf("%c", Character.toUpperCase(c));
            }

            // If there is another line after this one, add a newline to the output
            // to preserve the original line structure.
            if (inputScanner.hasNextLine()) {
                outputWriter.println();
            }
        }

        // Close the scanner
        inputScanner.close();
        // Close the writer
        outputWriter.close();
    }
}
