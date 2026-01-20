package src.DF5.Q4;
// AnException is a custom Exception class created by the programmer.
class AnException extends Exception {
    // Constructor that takes no arguments.
    public AnException() {
        super(); // Calls the parent Exception class constructor.
        System.out.println("Test");
    }

    // Constructor that accepts a message string.
    public AnException(String s) {
        super(s); // Calls the parent Exception class constructor with a message.
        System.out.println("AnException's message: " + s);
    }
}

// The main class to test the custom exception.
public class Test {
    public static void main(String[] args) {
        // Create an instance of AnException with a message.
        // This will print "AnException's message: First".
        Exception exp1 = new AnException("First");

        // Create an instance of AnException without a message.
        // This will print "Test".
        Exception exp2 = new AnException();

        // First try-catch block.
        try {
            if (1 + 1 == 2) {
                // Throws the first exception.
                throw exp1;
            }
            // This line is unreachable.
            throw exp2;
        } catch (Exception exp) {
            // Catches exp1 and prints its message.
            System.out.println("message 1: " + exp.getMessage());
        }

        // Second try-catch block.
        try {
            if (1 + 1 == 2) {
                // Throws the second exception.
                throw exp2;
            }
            // This line is unreachable.
            throw exp1;
        } catch (Exception exp) {
            // Catches exp2, which has no message (getMessage() returns null).
            System.out.println("message 2: " + exp.getMessage());
            // Immediately terminates the program.
            System.exit(0);
        }

        // This line is never reached because the program exits in the catch block above.
        System.out.println(exp1);
    }
}
