package src.DF7;
public class Sentence {
    private static String text;

    public Sentence(String aText) {
        text = aText; //[cite: 136]
    }

    // Public method that clients call
    public boolean isPalindrome() {
        // Calls the recursive helper with initial values [cite: 243]
        return isPalindrome(0, text.length() - 1);
    }

    // Recursive helper method
    public static boolean isPalindrome(int start, int end) {
        // Base Case: A string with 0 or 1 character is a palindrome [cite: 248]
        if (start >= end) {
            return true;
        }

        char first = Character.toLowerCase(text.charAt(start));// [cite: 251]
        char last = Character.toLowerCase(text.charAt(end));// [cite: 253]

        // Recursive Step
        if (Character.isLetter(first) && Character.isLetter(last)) {
            if (first == last) {
                // If letters match, check the inner substring
                return isPalindrome(start + 1, end - 1);// [cite: 260]
            } else {
                return false; // Letters don't match
            }
        } else if (!Character.isLetter(last)) {
            // If the last char isn't a letter, ignore it
            return isPalindrome(start, end - 1);// [cite: 270]
        } else {
            // If the first char isn't a letter, ignore it
            return isPalindrome(start + 1, end);// [cite: 276]
        }
    }


    public static void main(String[] args) {
        Sentence sentence = new Sentence("A man, a plan, a canal- Panama");
        isPalindrome(0);
    }
}