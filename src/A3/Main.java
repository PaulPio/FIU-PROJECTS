package src.A3;
import java.util.*;

public class Main {
    // A single Scanner object is created to read all input from the console.
    // It's declared as static so it can be accessed within the static main method.

    private static Scanner keyboard = new Scanner(System.in);

    /**
     * The main entry point of the application.
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args){
        // An ArrayList is used to store the DateTime objects. It's a dynamic array
        // that can grow as the user enters more date/time values.
        ArrayList<DateTime> list = new ArrayList<>();

        // Initial instructions for the user.
        System.out.println("Enter date/time in \"MM/DD/YYYY @ hh:mm:ss am/pm\" format.");


        // The loop continues as long as there is another line of input.
        // keyboard.hasNextLine() will block and wait for user input. It returns false
        // when the end-of-stream signal (Ctrl+D/Z) is received.
        while(keyboard.hasNextLine()){
            System.out.println("Enter the next date/time. Press Ctrl+D to end the sequence");
            String input = keyboard.nextLine();
            String[] tokens= input.split(" ");


            if(tokens.length != 4 || !tokens[1].equals("@") || !tokens[3].equalsIgnoreCase("am") && !tokens[3].equalsIgnoreCase("pm") ) {
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"");
                continue;
            }

            // The date part (e.g., "12/25/2024") is split by "/".
            String[] dateTokens = tokens[0].split("/");

            // The time part (e.g., "10:30:00") is split by ":".
            String[] timeTokens = tokens[2].split(":");

            // Validation to ensure the date and time parts themselves have the right number of components.
            if(dateTokens.length != 3 || timeTokens.length != 3) {
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"");
                continue;
            }

            // A try-catch block is used to handle potential errors during number parsing
            // and object creation. This prevents the program from crashing on bad input.
            try{
                // `Integer.parseInt()` converts the string parts into integers.
                // This can throw a `NumberFormatException` if a part is not a valid number.
                int     month = Integer.parseInt(dateTokens[0]),
                        day = Integer.parseInt(dateTokens[1]),
                        year = Integer.parseInt(dateTokens[2]),
                        hour = Integer.parseInt(timeTokens[0]),
                        minute = Integer.parseInt(timeTokens[1]),
                        second = Integer.parseInt(timeTokens[2]);

                // A new DateTime object is created. This assumes you have `DateTime` and `Date` classes defined.
                // The boolean `tokens[3].equalsIgnoreCase("am")` will be true for "am" and false for "pm".
                DateTime dateTime = new DateTime(new Date(day, month, year),hour,
                        minute, second, tokens[3].equalsIgnoreCase("am"));

                // Validates if the datetime is correct
                if(!DateTime.isValidDateTime(dateTime))
                    throw new DateTimeInvalidException(dateTime);

                // If all checks pass, the valid object is added to the list.
                list.add(dateTime);

            }catch(NumberFormatException exp){
                // This block catches errors if, for example, the user enters "12/AA/2024".
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"!");
            }
            catch (DateTimeInvalidException exp){
                // This catches the custom exception for logically invalid dates/times.
                System.out.println(exp.getMessage() + "Try again!");
            }
        }

        // After the user finishes entering data, the list is sorted.
        // This requires the `DateTime` class to implement the `Comparable<DateTime>` interface,
        // which defines how two `DateTime` objects should be compared.
        Collections.sort(list);

        // Header to make the output clear.
        System.out.println("\n--- Sorted Dates and Times ---");

        // A "for-each" loop iterates through the now-sorted list.
        for(DateTime dateTime: list)
            System.out.println(dateTime);

        // Closing the scanner object
        keyboard.close();

    }
}
