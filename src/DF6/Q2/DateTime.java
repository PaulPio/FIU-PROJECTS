package src.DF6.Q2;

/**
 * Represents a specific time on a specific date, using a 12-hour clock (am/pm).
 * It contains a Date object and time components (hour, minute, second).
 * Implements Comparable to allow sorting of DateTime objects.
 */
public class DateTime implements Comparable<DateTime>{

    // A Date object to hold the date part.
    private Date date;

    // Fields for the time part.
    private int hour;
    private int minute;
    private int second;

    // A boolean to represent am (true) or pm (false).
    private boolean am;

    /**
     * Constructor for creating a DateTime object.
     * It uses a 12-hour clock format for the input hour.
     * Note: 12am is stored as 0 internally for easier comparison.
     * @param date The Date object.
     * @param hour The hour (1-12).
     * @param minute The minute (0-59).
     * @param second The second (0-59).
     * @param am true for am, false for pm.
     */
    public DateTime(Date date, int hour, int minute, int second, boolean am) {
        this.date = date;
        this.hour = hour == 12? 0:hour;
        this.minute = minute;
        this.second = second;
        this.am = am;
    }

    /**
     * Overrides the default toString method for a custom string representation.
     * @return The DateTime formatted as "MM/DD/YYYY @ HH:MM:SS am/pm".
     */
    @Override
    public String toString() {
        return String.format("%s @ %02d:%02d:%02d %s", date, hour == 0?12:hour,
                minute, second, am? "am": "pm");
    }

    /**
     * A static utility method to validate a DateTime object.
     * @param dateTime The DateTime object to check.
     * @return true if the DateTime is valid, false otherwise.
     */
    public static boolean isValidDateTime(DateTime dateTime){
        Date date = dateTime.date;
        int hour = dateTime.hour, minute = dateTime.minute, second = dateTime.second;
        return Date.isValidDate(date) &&
                hour >= 0 && minute >= 0 && second >= 0 &&
                hour < 13 && minute < 60 && second < 60;
    }

    /**
     * Compares this DateTime with another DateTime object.
     * The comparison is hierarchical: Date -> AM/PM -> Hour -> Minute -> Second.
     * @param other The other DateTime object to compare to.
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(DateTime other) {
        // First, compare the date part. If they are different, return the result.
        if(this.date.compareTo(other.date) != 0)
            return this.date.compareTo(other.date);
        // If dates are the same, compare the am/pm flag. AM (true) comes before PM (false).
        if(this.am != other.am)
            return this.am?-1:1;
        // If am/pm is the same, compare the hour.
        if(this.hour != other.hour)
            return this.hour - other.hour;
        // If hours are the same, compare the minute.
        if(this.minute != other.minute)
            return this.minute - other.minute;
        // Finally, if all else is equal, compare the second.
        return this.second - other.second;
    }
}
