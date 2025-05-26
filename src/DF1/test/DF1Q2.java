package src.DF1.test;
/*
 Java static method that receives a
 String as its input parameter and returns true if the given string starts with a capital letter
 and has no non-alphabetical characters. The method returns false otherwise.
 */

public class DF1Q2 {
    public static void main(String[]args) {

        System.out.println(checkString("Apple"));
        System.out.println(checkString("!Apple"));
        System.out.println(checkString("apple"));


    }

    public static boolean checkString(String input){
        char initial = input.charAt(0); // chat at (0) is used to capture the fist letter of the String
        // character class is used to access the methods to manipulated chars

        // is upper case used to review if the first letter of string is an uppercase or not
        if (!Character.isUpperCase(initial)) {
            return false;
        }
        for (char c: input.toCharArray()) {
            //Enahnced for loop to review all the string for any non letter chars
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
