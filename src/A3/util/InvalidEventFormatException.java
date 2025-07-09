package src.A3.util;

/**
 * Exception class whenever the user introduces a wrong character when creating an event, in this case a comma ","
 */
public class InvalidEventFormatException extends Exception {
    private String message;

    // Constructors

    public InvalidEventFormatException(String message) {
      super(message);
    }
  public InvalidEventFormatException() {
      this.message = message;
  }

  // Message to indicate the user what went wrong
  @Override
  public String getMessage(){
    return "Illegal character " + message + ".";
  }
}
