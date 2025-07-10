package src.A3.driver;
import java.util.*;

import src.A3.util.*;
import src.A3.util.Date;

/**
 * The main class for the Event Organizer application.
 * It handles user input for events, processes commands, and prints event lists.
 */
public class EventOrganizer {

    // Initializing private static fields for both the scanner objecto for the user's input and the array list to store the events
    private static Scanner keyboard = new Scanner(System.in);
    private static ArrayList<Event> events = new ArrayList<>();

    public static void main(String[] args) {

        // --- Phase 1: Event Input ---
        // Printing the welcome message and instructions to the user.
        System.out.println("Please enter the list of all events! Enter \"Done\" when you finish" +
                "\nEvent name , Start Date and Time, End Date and Time, Host, Number of guests, Location");

        // This loop continuously prompts the user for event strings until "Done" is entered.
        while (true) {

            // String variable to hold the user's input line.
            String command = keyboard.nextLine();

            // The control statement to end the input loop.
            if (command.equalsIgnoreCase("Done")) {
                break;
            }

            // A try-catch block to handle any errors during parsing.
            try {
                // Attempt to parse the line and create an Event object
                String[] parts = command.split(",");
                if (parts.length != 6) {
                    // If there aren't exactly 6 parts, the format is wrong.
                    throw new InvalidEventFormatException("Invalid input: An event must have exactly 6 comma-separated fields.");
                }

                // Obtaining and assigning the information of the event, trim is used to delete the spaces
                String name = parts[0].trim();
                DateTime startDateTime = parseDateTime(parts[1].trim());
                DateTime endDateTime = parseDateTime(parts[2].trim());
                String host = parts[3].trim();
                int invitees = Integer.parseInt(parts[4].trim()); // Throws NumberFormatException if invalid
                String location = parts[5].trim();

                // Check if start date is after end date
                if(startDateTime.compareTo(endDateTime) > 0) {
                    throw new InvalidEventFormatException("Invalid input: The event's start time cannot be after its end time.");
                }

                // Adding the new event to the events array
                events.add(new Event(name, startDateTime, endDateTime, host, invitees, location));

                // Printing the message that the event was successfully added
                System.out.println("Event added successfully.");

            } catch (InvalidEventFormatException | NumberFormatException  | DateTimeInvalidException e) {
                // Catch parsing errors and prompt the user to try again
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.");
            }
        }

        // Sort the events list once all events have been entered
        Collections.sort(events);

        System.out.println("\nAll events entered. You may now enter commands.");

        // Show the new options to the user to view the events that are stored in the array list
        System.out.println("Commands: 'print', 'happening on DATE @ TIME', 'hosted by HOST', 'quit'");


        // Loop to process user commands
        while (true) {
            String commandLine = keyboard.nextLine();
            String[] commandParts = commandLine.split(" ", 3);
            String command = commandParts[0].toLowerCase();

            // A switch statement to determine which command to execute.
            switch (command) {
                case "quit":
                    // Exit the program.
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;

                case "print":
                    // Print all events in their sorted order.
                    System.out.println("\n--- All Events (Sorted) ---");
                    if (events.isEmpty()) {
                        System.out.println("No events to display.");
                    } else {
                        for (Event event : events) {
                            System.out.println(event);
                        }
                    }
                    System.out.println("---------------------------\n");
                    break;

                case "happening":
                    // Find and print events occurring at a specific time.
                    try {
                        if (commandParts.length < 3 || !commandParts[1].equalsIgnoreCase("on")) {
                            throw new InvalidEventFormatException("Invalid command. Use format: 'happening on MM/DD/YYYY @ hh:mm:ss am/pm'");
                        }
                        DateTime happeningTime = parseDateTime(commandParts[2]);
                        System.out.printf("\n--- Events Happening On %s ---\n", happeningTime);
                        boolean found = false;
                        for (Event event : events) {
                            // An event is happening if happeningTime is between start (inclusive) and end (inclusive)
                            if (event.getStartDateTime().compareTo(happeningTime) <= 0 && event.getEndDateTime().compareTo(happeningTime) >= 0) {
                                System.out.println(event);
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No events are happening at that time.");
                        }
                        System.out.println("---------------------------\n");
                    } catch (InvalidEventFormatException | DateTimeInvalidException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "hosted":
                    // Find and print events hosted by a specific person.
                    try {
                        if (commandParts.length < 3 || !commandParts[1].equalsIgnoreCase("by")) {
                            throw new InvalidEventFormatException("Invalid command. Use format: 'hosted by <hostname>'");
                        }
                        String hostName = commandParts[2];
                        System.out.printf("\n--- Events Hosted By %s ---\n", hostName);
                        boolean found = false;
                        for (Event event : events) {
                            if (event.getHost().equalsIgnoreCase(hostName)) {
                                System.out.println(event);
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("No events are hosted by that host.");
                        }
                        System.out.println("---------------------------\n");
                    } catch (InvalidEventFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    // Handle any unrecognized commands.
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }

    /**
     * Parses a string into a DateTime object.
     * @param dateTimeString The string to parse, in "MM/DD/YYYY @ hh:mm:ss am/pm" format.
     * @return A valid DateTime object.
     * @throws InvalidEventFormatException if the string format is incorrect or the date/time is invalid.
     * @throws DateTimeInvalidException if the format is correct but the date/time values are invalid.
     */
    private static DateTime parseDateTime(String dateTimeString) throws InvalidEventFormatException, DateTimeInvalidException  {
        // First, split the string into date and time parts using " @ " as the delimiter.
        // Example: "09/10/2025 @ 09:00:00 am" -> ["09/10/2025", "09:00:00 am"]
        String[] parts = dateTimeString.split(" @ ");
        if (parts.length != 2) {
            throw new InvalidEventFormatException("Invalid DateTime format. Expected 'Date @ Time'.");
        }

        // --- Parse the Date Part ---
        // Split the date part by "/" to get month, day, and year.
        // Example: "09/10/2025" -> ["09", "10", "2025"]
        String[] dateParts = parts[0].split("/");
        if (dateParts.length != 3) {
            throw new InvalidEventFormatException("Invalid Date format. Expected 'MM/DD/YYYY'.");
        }

        // --- Parse the Time Part ---
        // Split the time part by space to separate the time from "am/pm".
        // Example: "09:00:00 am" -> ["09:00:00", "am"]
        String[] timeAndAmPm = parts[1].split(" ");
        if (timeAndAmPm.length != 2) {
            throw new InvalidEventFormatException("Invalid Time format. Expected 'hh:mm:ss am/pm'.");
        }
        // Now, split the time itself by ":" to get hour, minute, and second.
        // Example: "09:00:00" -> ["09", "00", "00"]
        String[] timeParts = timeAndAmPm[0].split(":");
        if (timeParts.length != 3) {
            throw new InvalidEventFormatException("Invalid Time format. Expected 'hh:mm:ss'.");
        }

        // A try-catch block is used to handle errors that might occur when converting
        // string parts to numbers (e.g., if the user enters "abc" for the month).
        try {
            // Convert date strings to integers.
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            // Convert time strings to integers.
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);

            // Determine if it's AM or PM. Convert to lowercase for case-insensitive comparison.
            String ampm = timeAndAmPm[1].toLowerCase();
            if (!ampm.equals("am") && !ampm.equals("pm")) {
                // The meridian indicator must be exactly "am" or "pm".
                throw new InvalidEventFormatException("Time must end with 'am' or 'pm'.");
            }
            boolean isAm = ampm.equals("am");

            // --- Validation ---
            // Now that we have all the numbers, we must validate them.

            // Create a Date object and use its provided validator.
            Date date = new Date(day, month, year);
            if (!Date.isValidDate(date)) {
                // The combination of day, month, and year is not a real date (e.g., 02/30/2025).
                throw new InvalidEventFormatException("The date " + date + " is not a valid calendar date.");
            }

            // Validate the hour. In a 12-hour format, it must be from 1 to 12.
            if (hour < 1 || hour > 12) {
                throw new InvalidEventFormatException("Hour must be between 1 and 12.");
            }

            // Create the final DateTime object.
            DateTime dateTime = new DateTime(date, hour, minute, second, isAm);
            // Use the provided validator to check the full DateTime object. This checks
            // for things like minutes or seconds being 60 or more.
            if (!DateTime.isValidDateTime(dateTime)) {
                throw new DateTimeInvalidException(dateTime);
            }

            // If all checks pass, return the successfully created DateTime object.
            return dateTime;

        } catch (NumberFormatException e) {
            // This catch block executes if Integer.parseInt() fails.
            throw new InvalidEventFormatException("Date and time components must be numbers.");
        }
    }

}


