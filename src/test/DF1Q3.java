package src.test;

import java.util.Scanner;
public class DF1Q3 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        while(true){
            String command = keyboard.nextLine();
            if (command.equalsIgnoreCase("end"))
                break;

            String[] tokens = command.split(" ");
            for (int i = 0; i < tokens.length; i++) {
                System.out.printf("%d: %s\t\n", i, tokens[i]);
            }
            System.out.println("Please enter the next command: ");

        }
    }
}
