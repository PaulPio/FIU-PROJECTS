package src.A3.util;

/**
 * Class used to store the events
 */
public class Event implements Comparable <Event>{

    // Initializing private instance fields
    private Date date;
    private DateTime startDateTime;
    private DateTime endDateTime;
    private String eventName;
    private String host;
    private int numberOfInvitees;
    private String location;

    /**
     * Constructs an Event object.
     *
     * @param name             The name of the event.
     * @param startDateTime    The starting date and time of the event.
     * @param endDateTime      The ending date and time of the event.
     * @param host             The host of the event.
     * @param numberOfInvitees The number of people invited.
     * @param location         The location of the event.
     */

    public Event(String name, DateTime startDateTime, DateTime endDateTime, String host, int numberOfInvitees, String location) {
        this.eventName = name; // (String with no comma)
        this.startDateTime = startDateTime; // (MM/DD/YYYY @ hh:mm:ss am/pm)
        this.endDateTime = endDateTime;  // (MM/DD/YYYY @ hh:mm:ss am/pm)
        this.host = host; // (String with no comma)
        this.numberOfInvitees = numberOfInvitees; // (int)
        this.location = location; // (String with no comma)
    }



    // Getter methods to access private fields

    public Date getDate() {
        return date;
    }

    public DateTime getStartDateTime() {
        return startDateTime;
    }

    public DateTime getEndDateTime() {
        return endDateTime;
    }

    public String getEventName() {
        return eventName;
    }

    public String getHost() {
        return host;
    }

    public int getNumberOfInvitees() {
        return numberOfInvitees;
    }

    public String getLocation() {
        return location;
    }

    /**
     * Compares this event with another event for ordering.
     * The sorting logic is as follows:
     * 1. Events are sorted by their start time from earliest to latest.
     * 2. If start times are the same, they are sorted by duration from longest to shortest.
     * 3. If start and end times are also the same, they are sorted by name in alphabetical order.
     *
     * @param other The other event to be compared.
     * @return a negative integer, zero, or a positive integer as this event is less than,
     * equal to, or greater than the specified event.
     */
    @Override
    public int compareTo(Event other) {
        // 1. Compare by start date and time (earliest to latest)
        int startComparison = this.startDateTime.compareTo(other.startDateTime);
        if (startComparison != 0) {
            return startComparison;
        }

        // 2. If start times are equal, compare by duration (longest to shortest).
        // A longer duration means a later end time, so we compare end times in reverse order.
        int endComparison = other.endDateTime.compareTo(this.endDateTime);
        if (endComparison != 0) {
            return endComparison;
        }

        // 3. If start and end times are equal, compare by name alphabetically.
        return this.eventName.compareTo(other.eventName);
    }

    /**
     * Returns a string representation of the event in the original input format.
     * @return A formatted string representing the event.
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%s",
                eventName,
                startDateTime.toString(),
                endDateTime.toString(),
                host,
                numberOfInvitees,
                location);
    }
}
