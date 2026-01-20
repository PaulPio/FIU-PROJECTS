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

        //Welcome message
        System.out.println("Type a puzzle or Done to exit.");

        // Loop to process multiple puzzles, one per line.
        while(keyboard.hasNextLine()){
            String puzzle = keyboard.nextLine();

            if(puzzle.equalsIgnoreCase("done")){
                break;
            }

            // Clear static lists for the new puzzle.
            operands.clear();
            variables.clear();


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

            //detect every character participating in the puzzle and store it in the list of variables
            findAllVariables(puzzle);

            //solve method is called here
            solve(digitValues);

            System.out.println("\nType another puzzle or Done to exit.");
        }

        keyboard.close(); // closing the scanner object
    }

    /**
     * Finds all unique alphabetic characters in the puzzle string and populates the 'variables' list.
     * @param puzzle The complete puzzle string (e.g., "SEND + MORE = MONEY").
     */
    private static void findAllVariables(String puzzle) {

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


    /**
     * Method that solves the program by comparing both sides of the equation for the right outcome
     * @param digitValues  digitValues An array mapping characters to their currently assigned integer digits.
     */
    public static void solve(int[] digitValues) {

        // Find the next variable to assign
        char unassignedVariable = 0;
        boolean complete = true;

        // Loop through all unique letters to find the first one that hasn't been assigned a digit.
        for (char variable : variables) {
            if (digitValues[variable] == -1) { // -1 means it's unassigned.
                unassignedVariable = variable;
                complete = false;// If we find one, the assignment is not complete.
                break; // Exit the loop, as we only need one unassigned variable at a time.
            }
        }

        // BASE CASE: If all variables have been assigned a digit.
        // If the loop finished and 'complete' is still true, it means every variable has a digit.
        if (complete) {
            int operandsSum = 0;
            for (String operand : operands) {
                operandsSum += numericalValue(operand, digitValues);
            }
            int resultValue = numericalValue(result, digitValues);

            // If the sum of the operands equals the result, we've found a solution.
            if (operandsSum == resultValue) {
                System.out.print("Solution: ");
                for (char var : variables) {
                    System.out.print(var + ": " + digitValues[var] + " | ");
                }
                System.out.println();
            }
            return; // End this recursive path.
        }

        // RECURSIVE STEP: Try assigning each unused digit to the unassigned variable.

        // Before trying new digits, determine which are already in use in this path.
        // This array is created fresh in each call to check the current state.
        boolean[] usedDigits = new boolean[10];
        for (char v : variables) {
            if (digitValues[v] != -1) { // If a variable has a digit mark the digit as used
                usedDigits[digitValues[v]] = true;
            }
        }
        // Loop through every possible digit from 0 to 9.
        for (int digit = 0; digit < 10; digit++) {
            //  Check if the digit is already used.
            if (!usedDigits[digit]) {
                // Check for leading zero violation.
                if (digit == 0 && isFirstLetter(unassignedVariable)) {
                    continue; // Skip this digit, as leading letters can't be zero.
                }

                // assign the digit to the current variable.
                digitValues[unassignedVariable] = digit;

                // Call solve() again to continue assigning digits to the unassigned variable.
                solve(digitValues);

                //After the recursive call returns, undo the assignment.
                // It frees up the variable and the digit, allowing the loop
                // to try the next digit for the current variable in the next iteration.
                digitValues[unassignedVariable] = -1;
            }
        }
    }

    /**
     * Helper method to check if a character is the first letter of any word.
     * @param c The character to check.
     * @return true if the character is a first letter, false otherwise.
     */
    private static boolean isFirstLetter(char c) {
        // Check if the character is the first letter of the result word (and the word has more than one letter).
        if (result.length() > 1 && result.charAt(0) == c)
            return true;
        // Loop through all the operand words.
        for (String operand : operands) {
            // Check if the character is the first letter of an operand (and the operand has more than one letter).
            if (operand.length() > 1 && operand.charAt(0) == c) return true;
        }
        // If the character was not found as a leading letter in the result or any operand, return false.
        return false;
    }
}