package src.A1.test;
import src.A1.util.*;
import java.util.Scanner;
// Main program to run the assignment
public class Main {

    private static boolean checkFirstName(String input){
        /* Method to check if the first name is all letters and to change the first letter to
        upper case */

        // Must start with a capital letter. If the first char is a dot, this will fail.
        if (!Character.isUpperCase(input.charAt(0))) {
            return false;
        }

        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        // enhance for loop to run across the char array to review if the array is all letters
        //if true it will change the first letter to upper case, if false it will go back to user
        for(char c: chars){
            if(!Character.isLetter(c))
                return false;
        }
        return true;
    }

    private static boolean checkLastName(String input){
        /* Method to check if the last name is all letters and to change the first letter to
        upper case. Also check that there is maximum one "." */
        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        int dotCount = 0; // counter of dots "."

        // Must start with a capital letter. If the first char is a dot, this will fail.
        if (!Character.isUpperCase(input.charAt(0))) {
            return false;
        }
        // enhance for loop to run across the char array to review if the array is all letters
        //if true it will change the first letter to upper case, if false it will go back to user
        for(char c: chars){
            if (c == '.') {
                dotCount++;
                if (dotCount > 1)
                    return false; // If it has more than 1 dot, then it will got back to user
                }
            else if(!Character.isLetter(c))
                    return false;
            }
        return true;
    }

    private static boolean checkPid(String input){
        /* Method to check if the panther id is all numbers and has only 7 numbers */
        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        // enhance for loop to run across the char array to review if the array is all numbers

        // Check if it has 7 numbers, anything else is false and does not begin in 0
        if (input.length() != 7 || input.charAt(0) == 0)
            return false;

        for(char c: chars){
            if(!Character.isDigit(c))
                return false; // A character is not a number
        }
        return true; // All characters are numbers
    }

    private static boolean checkScore(String input){
        /* Method to check if the score is all numbers and goes from 0 to 100 */
        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars

        // checks if its between 0 to 100
        int score = Integer.parseInt(input);
        if (score < 0 || score > 100)
            return false;

        // enhance for loop to run across the char array to review if the array is all numbers
        for(char c: chars){
            if(!Character.isDigit(c))
                return false; // A character is not a number
        }
        return true; // All characters are numbers
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Scanner object to grab user input
        Gradebook gradebook = new Gradebook(); // New gradebook object to keep students scores


        //Welcome message
        System.out.println("Welcome to my grade book!\n" +
                " Please enter the information of the first student using the following format:\n" +
                " firstName lastName PID grade .\n" +
                " Press Enter when you are done.");
        // While loop to get user info through the command prompt
        while(true){

            String input = keyboard.nextLine();
            if (input.equalsIgnoreCase("Done")) // if the user types done, the loop ends
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
            String idStr = tokens[2]; // assigning id value
            String scoreStr = tokens[3]; // assigning score value


            //Check if the items type by the user are ok
            if (checkFirstName(firstName) == false){
                System.out.println("First name is entered incorrectly. Please try again.\n");
                continue;
            }
            if (checkLastName(lastName) == false){
                System.out.println("Last name is entered incorrectly. Please try again.\n");
                continue;
            }
            if (checkPid(idStr) == false){
                System.out.println("Panther ID is entered incorrectly. Please try again.\n");
                continue;
            }
            if (checkScore(scoreStr) == false){
                System.out.println("Score is entered incorrectly. Please try again.\n");
                continue;
            }

            // Assinging numeric values after checking if they were ok
            int id = Integer.parseInt(tokens[2]); // assigning id value, parseint function to chande data type to int
            int score = Integer.parseInt(tokens[3]); // assigning score value, parseint function to chande data type to int


            // Create the Grade,  and student objects
            Grade currentGrade = new Grade(score);
            Student currentStudent = new Student(firstName,lastName,id,currentGrade);

            // Adding students to the gradebook
            gradebook.addStudent(currentStudent);

            // Message to user to add new student info. Done when finished
            System.out.println(" Please enter the information of the next student using the same format.\n" +
                    " If there is no more students, please enter the keyword DONE .\n" +
                    " Press Enter when you are done.");
        }

        while(true){ // command handling phase
            System.out.print("Please enter a new command. ");
            String command = keyboard.nextLine();
            if (command.equals("quit")){
                break;
            }
            else if (command.equalsIgnoreCase("median score")){
                System.out.println("Median is " + gradebook.calculateMedian());
            } else if (command.equalsIgnoreCase("median letter")) {
                double medianScore = gradebook.calculateMedian();
                String letter = Grade.convertToLetterGrade(medianScore);
                System.out.println("Median letter is " + letter);
            } else if (command.startsWith("name ")) {
                String [] commandTokens = command.split(" ");
                int givenID = Integer.parseInt(commandTokens[1]);
                gradebook.getFullName(givenID);
                System.out.println("The full name is " + gradebook.getFullName(givenID));

            } else
                System.out.println("Illegal command. Please try again.");
        }

    }

}
