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

        // Printing the welcome message to the user
        System.out.println("Please enter the list of all events! Enter \"Done\" when you finish" +
                "\nEvent name , Start Date and Time, End Date and Time, Host, Number of guests, Location");

        // Loop to read event inputs from the user
        while (true) {

            // String variable to hold the user's input
            String command = keyboard.nextLine();

            // Control statement to end the loop
            if (command.equalsIgnoreCase("Done")) {
                break;
            }

            try {
                // Attempt to parse the line and create an Event object
                String[] parts = command.split(",");
                if (parts.length != 6) {
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

            } catch (InvalidEventFormatException | NumberFormatException e) {
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

            switch (command) {
                case "quit":
                    System.out.println("Exiting program.");
                    keyboard.close();
                    return;

                case "print":
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
                        System.out.println("-------------------------------------\n");
                    } catch (InvalidEventFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "hosted":
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
                        System.out.println("-----------------------------\n");
                    } catch (InvalidEventFormatException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }

    /**
     * Parses a string into a DateTime object.
     *
     * @param dateTimeString The string to parse, in "MM/DD/YYYY @ hh:mm:ss am/pm" format.
     * @return A valid DateTime object.
     * @throws InvalidEventFormatException if the string format is incorrect or the date/time is invalid.
     */
    private static DateTime parseDateTime(String dateTimeString) throws InvalidEventFormatException {
        String[] parts = dateTimeString.split(" @ ");
        if (parts.length != 2) {
            throw new InvalidEventFormatException("Invalid DateTime format. Expected 'Date @ Time'.");
        }

        // Parse Date part
        String[] dateParts = parts[0].split("/");
        if (dateParts.length != 3) {
            throw new InvalidEventFormatException("Invalid Date format. Expected 'MM/DD/YYYY'.");
        }

        // Parse Time part
        String[] timeAndAmPm = parts[1].split(" ");
        if (timeAndAmPm.length != 2) {
            throw new InvalidEventFormatException("Invalid Time format. Expected 'hh:mm:ss am/pm'.");
        }
        String[] timeParts = timeAndAmPm[0].split(":");
        if (timeParts.length != 3) {
            throw new InvalidEventFormatException("Invalid Time format. Expected 'hh:mm:ss'.");
        }

        try {
            int month = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);
            int second = Integer.parseInt(timeParts[2]);

            String ampm = timeAndAmPm[1].toLowerCase();
            if (!ampm.equals("am") && !ampm.equals("pm")) {
                throw new InvalidEventFormatException("Time must end with 'am' or 'pm'.");
            }
            boolean isAm = ampm.equals("am");

            Date date = new Date(day, month, year);
            if (!Date.isValidDate(date)) {
                throw new InvalidEventFormatException("The date " + date + " is not a valid calendar date.");
            }

            // Validate hour range
            if (hour < 1 || hour > 12) {
                throw new InvalidEventFormatException("Hour must be between 1 and 12.");
            }

            DateTime dateTime = new DateTime(date, hour, minute, second, isAm);
            if (!DateTime.isValidDateTime(dateTime)) {
                throw new InvalidEventFormatException("The time is not valid (e.g., minutes/seconds >= 60).");
            }

            return dateTime;

        } catch (NumberFormatException e) {
            throw new InvalidEventFormatException("Date and time components must be numbers.");
        }
    }

}


