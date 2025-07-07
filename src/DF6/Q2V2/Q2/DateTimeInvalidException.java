package src.DF6.Q2V2.Q2;

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
