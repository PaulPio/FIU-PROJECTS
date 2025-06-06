package src.A1.test;
import src.A1.util.*;
import java.util.Scanner;
// Main program to run the assignment
public class Main {

    private static boolean checkFirstName(String input){
        /* Method to check if the first name is all letters and to check if the first letter is
        upper case */

        // Must start with a capital letter. If the first char is a dot, this will fail.
        if (!Character.isUpperCase(input.charAt(0))) {
            return false;
        }

        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        // enhance for loop to run across the char array to review if the array is all letter
        for(char c: chars){
            if(!Character.isLetter(c))
                return false;
        }
        return true;
    }

    private static boolean checkLastName(String input){
        /* Method to check if the last name is all letters and to check if the first letter is
        upper case. Also check that there is maximum one "." */
        char[] chars = input.toCharArray(); // toCharArray converts the input variable into an array of chars
        int dotCount = 0; // counter of dots "."

        // Must start with a capital letter. If the first char is a dot, this will fail.
        if (!Character.isUpperCase(input.charAt(0))) {
            return false;
        }
        // enhance for loop to run across the char array to review if the array is all letters
        // The dot count variable is increased everytime the for loop detects a ".". if more than one the method
        // will return false, else, the else if will check if there is a non letter character, if false te method will end
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
        if (input.length() != 7 || input.charAt(0) == '0')
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


        // enhance for loop to run across the char array to review if the array is all numbers
        for(char c: chars){
            if(!Character.isDigit(c))
                return false; // A character is not a number
        }

        // checks if its between 0 to 100
        int score = Integer.parseInt(input);
        if (score < 0 || score > 100)
            return false;

        return true; // All characters are numbers
    }

    public static boolean tokenChecker(String [] tokens, int numTokens){
        //Check if the number is equal to 4, if more the user has to type again the info
        if(tokens.length != numTokens){
            System.out.printf("# of tokens in each line must be %d. Please try again.\n", numTokens);
            return true; // continue makes the loop to start again
        }
        else return false;
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

            // Calling the tokens checkr method, if true it will go the next iteration of loop, if false,
            // it will continue this iteration
            if (tokenChecker(tokens, 4)) continue;

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
            gradebook.addStudent(currentStudent, id);

            // Message to user to add new student info. Done when finished
            System.out.println(" Please enter the information of the next student using the same format.\n" +
                    " If there is no more students, please enter the keyword DONE .\n" +
                    " Press Enter when you are done.");
        }

        while(true){ // command handling phase
            System.out.print("Please enter a new command. ");
            String command = keyboard.nextLine();

            // Command to end program
            if (command.equalsIgnoreCase("quit")){
                break;
            }
            // Command to calculate Median Score
            else if (command.equalsIgnoreCase("median score")){
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Median is " + gradebook.calculateMedianScore());
            }
            // Command to calculate Median Letter Grade. It uses the calculate median score method to get the score
            // and the uses the convertToLetterGrade to get the median letter value of the score
            else if (command.equalsIgnoreCase("median letter")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                double medianScore = gradebook.calculateMedianScore();
                String letter = Grade.convertToLetterGrade(medianScore);
                System.out.println("Median letter is " + letter);
            }
            // Command to get the full name of the student using the student id.
            // Creating an array of string, separating the elements through the spaces
            // between words to get the student id
            else if (command.toLowerCase().startsWith("name ")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                String [] commandTokens = command.split(" "); // Splitting the user typed string into an array
                if(tokenChecker(commandTokens,2)) continue; // token checker if there are 2 tokens
                int givenID = Integer.parseInt(commandTokens[1]); // Student id
                System.out.println(gradebook.getFullName(givenID)); // Printing result of the function
            }
            // Command to get the minimum score
            else if (command.equalsIgnoreCase("min score")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Minimum score is " + gradebook.getMinScore());
            } // Command to get the maximum score
            else if (command.equalsIgnoreCase("max score")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Maximum score is " + gradebook.getMaxScore());
            }
            // Command to get the maximum letter grade
            else if (command.equalsIgnoreCase("max letter")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Maximum letter grade is " + gradebook.getMaxLetter());
            }
            // Command to get the minimum letter grade
            else if (command.equalsIgnoreCase("min letter")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebookPa
                System.out.println("Minimum letter grade is " + gradebook.getMinLetter());
            }
            // Command to get change the grade of the student. First we get the student id and the new grade by
            // splitting the string in an array
            else if (command.toLowerCase().startsWith("change ")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                String [] commandTokens = command.split(" "); // Splitting the user typed string into an array
                if(tokenChecker(commandTokens,3)) continue; // token checker if there are 3 tokens
                // Check if the score was written properly, false will make the program go to next iteration ,
                // true will continue this iteration
                if (!checkScore(commandTokens[2])){
                    System.out.println("Score is entered incorrectly. Please try again.\n");
                    continue;
                }
                int givenID = Integer.parseInt(commandTokens[1]); // Student id
                Grade givenScore = new Grade (Integer.parseInt(commandTokens[2])); // New grade object
                System.out.println(gradebook.changeGrade(givenID, givenScore));
            }
            //Command to get the average letter grade
            else if (command.equalsIgnoreCase("average letter")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Average Letter Grade  is " + gradebook.calculateAverageLetterGrade());
            }
            //Command to get the average score
            else if (command.equalsIgnoreCase("average score")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                System.out.println("Average score  is " + gradebook.calculateAverageScore());
            }
            // Command to tabulate the students scores
            else if (command.equalsIgnoreCase("tab scores")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                gradebook.tabulateScores();
            }
            // Command to tabulate the students letter grades
            else if (command.equalsIgnoreCase("tab letters")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                gradebook.tabulateLetterGrade();
            }
            // Command to show letter grade given the panther id provided by yser
            else if (command.toLowerCase().startsWith("letter ")) {
                if (gradebook.isEmpty()) continue; // continues if there are no students in gradebook
                String [] commandTokens = command.split(" "); // Splitting the user typed string into an array
                if(tokenChecker(commandTokens,2)) continue; // token checker if there are 2 tokens
                int givenID = Integer.parseInt(commandTokens[1]);
                System.out.println(gradebook.getLetterGrade(givenID));
            }
            // Error message
            else
                System.out.println("Illegal command. Please try again.");
        }

    }

}
