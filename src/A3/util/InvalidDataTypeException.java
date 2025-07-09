package src.A3.util;

/**
 * Exception when the user types the wrong data type
 */
public class InvalidDataTypeException extends Exception {

    private String message;

    public InvalidDataTypeException(String message) {
        super(message);
    }

  // Message to indicate the user what went wrong
  @Override
  public String getMessage(){
    return "Illegal data type " + message + ".";
  }
}
