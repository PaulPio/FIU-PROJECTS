package src.A3.util;


public class DateTimeInvalidException extends Exception{
    private DateTime invalidDateTime;

    // Constructor of the exception
    public DateTimeInvalidException(String message) {
        super();
        System.out.println(message);
    }

        public DateTimeInvalidException(DateTime invalidDateTime) {
            this.invalidDateTime = invalidDateTime;
        }
        @Override
        public String getMessage(){
            return "Illegal Date/Time " + invalidDateTime + ".";
        }
}
