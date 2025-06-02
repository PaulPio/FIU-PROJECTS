package src.DF2.test;
import src.DF2.util.*;


public class DF2 {

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

    public static void main(String[] args) {
        // Creating Students objects for the Gradebook array
        // Checking scores
        Students first = new Students("A", "B", 5646546, 90);
        Students second = new Students("B", "Y", 4564586, 80);
        Students third = new Students("C", "Q", 5641225, 75);
        Students fourth = new Students("D", "N", 1235467, 65);

        // Initializing the gradebook array with the list of students and their info
        Gradebook myGradeBook = new Gradebook(
                new Students[]{first, second, third, fourth}
        );
        // Calling Min and Max Score students methods
        System.out.println("The Maximum scores is " + myGradeBook.getMaxScore());

        System.out.println("The Minimum scores is " + myGradeBook.getMinScore());




    }

}
