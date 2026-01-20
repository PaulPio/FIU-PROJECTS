package src.DF6.Q2;
import java.util.*;

public class Test {

    public static void main(String[] args) {


        Scanner keyboard = new Scanner(System.in);
        ArrayList <String> tokens = new ArrayList();

        System.out.println("Enter date/time entries in the format 'MM/DD/YYYY @ hh:mm:ss am/pm'.");

        System.out.print("Enter entry: ");
        String inputLine = keyboard.nextLine();


        // A try-catch block is used to handle potential errors during parsing.
        // This prevents the program from crashing on bad input.
        try{

        // Create the date object first , use the exception subclass that we design
        // Step 1: Split the input into date and time parts using " @ " as the separator.
        String[] mainParts = inputLine.split(" @ ");

        // Exception if it does not have the @ to split the code
        if (mainParts.length != 2) {
            throw new DateTimeInvalidException("Invalid format. Must contain ' @ ' between date and time.");
        }

        // Getting the parts of the date and time
        String dateStr = mainParts[0]; // Should be "MM/DD/YYYY"
        String timeStr = mainParts[1]; // Should be "hh:mm:ss am/pm"

        // Step 2: Split the date part into month, day, and year.
        String[] dateParts =  dateStr.split("/");

        //Exception to verify if the date has 3 parts
        if (dateParts.length != 3) {
            throw new DateTimeInvalidException("Invalid date format. Please use 'MM/DD/YYYY'.");
        }

        int month = Integer.parseInt(dateParts[0]);
        int day = Integer.parseInt(dateParts[1]);
        int year = Integer.parseInt(dateParts[2]);

        // Step 3: Split the time part into the time itself and the am/pm marker.

        String[] timeAndPeriod = timeStr.split(" ");

        if (timeAndPeriod.length != 2) {
            throw new DateTimeInvalidException("Invalid time format. Must have a space before 'am' or 'pm'.");
        }
        String timeDigits = timeAndPeriod[0]; // "hh:mm:ss"
        String period = timeAndPeriod[1];     // "am" or "pm"

        // Step 4: Split the time digits into hour, minute, and second.
        String[] timeParts = timeDigits.split(":");

        //Exception to verify if the time has 3 parts

        if (timeParts.length != 3) {
            throw new DateTimeInvalidException("Invalid time format. Please use 'hh:mm:ss'.");
        }
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        int second = Integer.parseInt(timeParts[2]);

        // Step 5: Determine if it's AM or PM.
        boolean isAm;
        if (period.equalsIgnoreCase("am")) {
            isAm = true;
        } else if (period.equalsIgnoreCase("pm")) {
            isAm = false;
        } else {
            throw new DateTimeInvalidException("Time must end with 'am' or 'pm'.");
        }


        // Step 6: Create the Date and DateTime objects.
        Date date = new Date(day, month, year);
        DateTime dateTime = new DateTime(date, hour, minute, second, isAm);

        // Step 7: Use the validation method to check if the date/time values are logical.
        if (!DateTime.isValidDateTime(dateTime)) {
            throw new DateTimeInvalidException("The date or time value is invalid (e.g., day 32, hour 15).");
        }
        }catch (DateTimeInvalidException e) {
            // This block catches our custom exceptions for format and logic errors.
            System.out.println("\nInput Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            // This block specifically catches errors from trying to parse a non-numeric string like "1a".
            System.out.println("\nInput Error: A part of the date or time is not a valid number.");
        } finally {
            // The finally block ensures the scanner is closed, whether an error occurred or not.
            keyboard.close();
        }
    }


}
