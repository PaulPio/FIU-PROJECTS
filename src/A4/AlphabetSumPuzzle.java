package src.A4;

import java.util.ArrayList;
import java.util.Scanner;

public class AlphabetSumPuzzle {
    // A list to hold all unique characters (variables) found in the puzzle.
    private static ArrayList<Character> variables = new ArrayList<>();

    // A list to hold all the words (operands) on the left side of the sum.
    private static ArrayList<String>operands = new ArrayList<>();

    // A string to hold the word that is the result of the sum.
    private static String result = null;

    public static void main(String[] args){
        // Scanner to read input from the user.
        Scanner keyboard = new Scanner(System.in);

        // Loop to process multiple puzzles, one per line.
        while(keyboard.hasNextLine()){
            String puzzle = keyboard.nextLine();
            // Split the puzzle string by any non-alphabetic characters to extract the words.
            String[] tokens = puzzle.split("[^a-zA-Z]");

            // Iterate through the tokens to separate operands from the result.
            for(int i = 0; i < tokens.length-1;i++)
                // Ensure empty tokens are not added.
                if(tokens[i].length() != 0)
                    operands.add(tokens[i]);//all tokens but the last one represent the sum operands

            //last token must be the sum result
            result = tokens[tokens.length-1];

            // An array to map characters (by their ASCII value) to assigned integer digits.
            int[] digitValues = new int[256];

            // Initialize all character mappings to -1, indicating no digit has been assigned yet.
            for(int i = 0; i < 256;i++)
                digitValues[i] = -1;//symbol for empty cell!
            //solve method is called here

            //detect every character participating in the puzzle and store it in the list of variables
            findAllVariables(puzzle);


            printAllCombinations(digitValues);

            digitValues['T'] = 1;
            digitValues['H'] = 2;
            digitValues['E'] = 3;
            System.out.println("This is an example: Numerical value of " +
                    "THE is " +
                    numericalValue("THE", digitValues));
        }

        keyboard.close(); // closing the scanner object
    }

    /**
     * Finds all unique alphabetic characters in the puzzle string and populates the 'variables' list.
     * @param puzzle The complete puzzle string (e.g., "SEND + MORE = MONEY").
     */
    private static void findAllVariables(String puzzle) {
        variables.clear(); // Clear the list for new puzzles.
        for(char c: puzzle.toCharArray())
            // If the character is a letter and not already in our list, add it.
            if(Character.isLetter(c) && !variables.contains(c))
                variables.add(c);
    }

    /**
     * Calculates the integer value of a word based on the assigned digits for its characters.
     * @param word The word to be converted to a number (e.g., "THE").
     * @param digitValues The array mapping characters to their assigned digits.
     * @return The integer value of the word, or -1 if any character has not been assigned a digit.
     */
    private static int numericalValue(String word, int[] digitValues) {
        int rv = 0; // 'rv' will hold the resulting numerical value.
        // Iterate over each character in the word.
        for(char c: word.toCharArray())
            // If a character in the word has not been assigned a digit, the value is incomplete.
            if(digitValues[c] < 0)//if c is not assigned to any value
                return -1;// // Return -1 to indicate an error or unassigned variable.
            else
                // Build the number. For each new character, multiply the current value by 10
                // and add the digit corresponding to the new character.
                rv = 10 * rv + digitValues[c];
        return rv; // Return the final calculated value.

    }

    //THE: 3-digit integer
    //numerical value = T * 100 + H * 10 + E * 1
    // 1 * E + 10 * H + 100 * T
    // 1 * E + 10 * (H + 10 * T)

    /**
     * Method that recursively generates and prints all possible combinations of digit assignments for the puzzle's variables.
     * @param digitValues digitValues An array mapping characters to their currently assigned integer digits.
     */
    private static void printAllCombinations(int[] digitValues){

        // Assume initially that all variables have been assigned a digit.
        boolean complete = true;
        // A placeholder for the first variable we find that hasn't been assigned a digit.
        char unassignedVariable = 0;

        // Loop through all unique letters (variables) identified in the puzzle.
        for (char variable : variables)
            // Check if the current variable has not been assigned a digit yet (its value is -1).
            if(digitValues[variable] == -1) { // variable has not been assigned to any value yet
                complete = false; // assignmetn is not complete
                unassignedVariable = variable; // variable without assignment is stored in the unassignedVariable
                // Exit the loop since we only need to find one unassigned variable at a time.
                break;
            }

        // BASE CASE: This block executes if the loop above completed without finding any unassigned variables.
        // This means every letter has been assigned a digit.
        if(complete){

            // Enhanced for loop that goes through all the char in the array list ot print them with their numerical values combinations
            for(char variable : variables){
                // Print the current combination of letters and their assigned digits.
                System.out.print(variable + ": " + digitValues[variable] + "| ");
            }

            // Move to the next line for the next combination.
            System.out.println();
            }
        // RECURSIVE STEP: This block executes if we found an unassigned variable.
        else{
            for(int i = 0; i <10; i++){
                digitValues[unassignedVariable] = i; // assigne the unassignedVariable to one of the possible digits
                printAllCombinations(digitValues); // recursive call


            }

            // After the loop has tried all digits (0-9) for the current unassigned variable,
            // reset its value to -1. This allows more  recursive calls to try different combinations.
            digitValues[unassignedVariable] = -1;

        }

    }
}