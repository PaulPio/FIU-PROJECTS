package src.A3.util;


public class DateTimeInvalidException extends Exception{
    private DateTime invalidDateTime;

        /**
         * Constructs a new DateTimeInvalidException.
         * @param invalidDateTime The DateTime object that failed validation.
         */
        public DateTimeInvalidException(DateTime invalidDateTime) {
            super(); // Call the parent constructor
            this.invalidDateTime = invalidDateTime;
        }

    /**
     * Provides a detailed message about the invalid DateTime.
     * @return A string message indicating the illegal date/time.
     */
        @Override
        public String getMessage(){
            return "Illegal Date/Time " + invalidDateTime + ".";
        }
}
