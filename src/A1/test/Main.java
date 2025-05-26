package src.A1.test;
import src.A1.util.*;
import java.util.Scanner;
// Main program to run the assignment
public class Main {

    private static boolean checkFirstName(String input){
        /* Method to check if the first name is all letters and to change the first letter to
        upper case */
        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        // enhance for loop to run across the char array to review if the array is all letters
        //if true it will change the first letter to upper case, if false it will go back to user
        for(char c: chars){
            if(!Character.isLetter(c))
                return false;
        }
        return Character.isUpperCase(chars[0]);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Scanner object to grab user input
       // Gradebook gradebook = new Gradebook(); // New gradebook object to keep students scores

        // While loop to get user info through the command prompt
        while(true){
            String input = keyboard.nextLine();
            if (input.equals("Done")) // if the user types done, the loop ends
                break;

            // Separate the string into an array of words using the spaces between words
            String[] tokens = input.split(" ");


            //Check if the number is equal to 4, if more the user has to type again the info
            if(tokens.length != 4){
                System.out.println("# of tokens in each line must be 4. Please try again.\n");
                continue; // continue makes the loop to start again
            }


            // Assigning the values of the Student attributes
            // First, we assigg the values of the user input to their variable before creating the Student object

            String firstName = tokens[0]; // assigning first name value
            String lastName = tokens[1];// assigning last name value
            int id = Integer.parseInt(tokens[2]); // assigning id value, parseint function to chande data type to int
            int grade = Integer.parseInt(tokens[3]); // assigning score value, parseint function to chande data type to int

        }

    }

}
