package src.A3.util;

/**
 * Exception class whenever the user introduces a wrong character when creating an event, in this case a comma ","
 */
public class InvalidEventFormatException extends Exception {
    private String message;

    /**
     * Constructs a new InvalidEventFormatException with the specified detail message.
     * @param message The detail message explaining the reason for the exception.
     */
    public InvalidEventFormatException(String message) {
        super(message);
    }
}