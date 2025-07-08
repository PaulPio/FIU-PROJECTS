package src.A3;

/**
 * Exception class whenever the user introduces a wrong character, in this case a comma ","
 */
public class InvalidCharacterException extends Exception {
    private String message;

    // Constructors

    public InvalidCharacterException(String message) {
      super(message);
      System.out.println(message);
    }
  public InvalidCharacterException() {
      this.message = message;
  }

  // Message to indicate the user what went wrong
  @Override
  public String getMessage(){
    return "Illegal character " + message + ".";
  }
}
