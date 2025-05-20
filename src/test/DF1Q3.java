package src.test;
/*
Write a Java program that (1) receives multiple lines from System.in, (2) split each
line into its participating words (use String.split method), and (3)
 print out the numbered list of words in each line. End the program after seeing the keyword "end" in a line.
 */
import java.util.Scanner;
public class DF1Q3 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in); // Initializng scanner object to read user input
        while(true){ // run a while loop to keep reading the user input. Only ends when user types "end"
            String command = keyboard.nextLine();
            if (command.equalsIgnoreCase("end"))
                //User types "end", no matter if case or no, the loop breaks
                break;

            // Split the string into a list of multiples strings divided by the space " "
            String[] tokens = command.split(" ");

            // For loop through the string array to read the different words typed by the user
            for (int i = 0; i < tokens.length; i++) {
                System.out.printf("%d: %s\t\n", i, tokens[i]);
            }
            // Message to indicate user to write a new String
            System.out.println("Please enter the next command: ");

        }
    }
}
