package src.DF6.Q2;

public class DateTimeInvalidException extends IllegalArgumentException{
    // Constructor of the exception
    public DateTimeInvalidException(String message) {
        super();
        System.out.println(message);
    }
    public DateTimeInvalidException() {
        super();
        System.out.println("No args constructor");
    }

    public DateTimeInvalidException(Throwable cause) {
        super(cause);
    }
}
