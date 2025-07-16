package src.DF8;

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
        /* SLOW solution
        int power = word.length()-1;
        for(char c: word.toCharArray())
            if(digitValues[c] < 0)//if c is not assigned to any value
                return -1;//error
            else
                rv += Math.pow(10, power--) * digitValues[c];
        return rv;
        */
    }

    //THE: 3-digit integer
    //numerical value = T * 100 + H * 10 + E * 1
    // 1 * E + 10 * H + 100 * T
    // 1 * E + 10 * (H + 10 * T)

    private static void printAllCombinations(int[] digitValues){
        //Your code here!
        if (digitValues.length == 0)
            return;


    }
}