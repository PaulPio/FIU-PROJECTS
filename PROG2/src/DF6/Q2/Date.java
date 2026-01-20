package src.DF6.Q2;

/**
 * Represents a calendar date with day, month, and year.
 * It implements the Comparable interface to allow sorting of Date objects.
 */
public class Date implements Comparable<Date>{

    // Private fields to store the day, month, and year.
    private int day;
    private int month;
    private int year;

    /**
     * Overrides the default toString method to provide a custom string representation.
     * @return The date formatted as "MM/DD/YYYY".
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", month, day, year);
    }

    //Getters for the date attributes
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }

    /**
     * Constructor to create a new Date object.
     * @param day The day of the month.
     * @param month The month of the year.
     * @param year The year.
     */
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Compares this date with another date.
     * The comparison is done first by year, then by month, and finally by day.
     * @param other The other Date object to compare to.
     * @return a negative integer, zero, or a positive integer as this date is
     * less than, equal to, or greater than the specified date.
     */
    @Override
    public int compareTo(Date other) {
        if(this.year != other.year)
            return this.year - other.year;//new Integer(year).compareTo(other.year);
        if(this.month != other.month)
            return this.month - other.month;
        return this.day - other.day;
    }

    /**
     * A static utility method to check if a given Date object is valid.
     * It checks for valid month and day ranges, including leap years.
     * @param date The Date object to validate.
     * @return true if the date is valid, false otherwise.
     */
    public static boolean isValidDate(Date date) {
        int day = date.day, month = date.month, year = date.year;

        // Basic checks for year, month, and day ranges.
        if(year < 1 || day < 1 || month < 1 || month > 12)
            return false;

        // Check the number of days based on the month.
        switch (month){
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return day <= 31;
            case 4: case 6: case 9: case 11:
                return day <= 30;
            default://February
                if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)//leap year
                    return day <=29;
                else
                    return day <= 28;
        }
    }
}
