
import java.util.Random;

/**
 * Program that fills an array of 10 numbers with random integer in [0,100]
 * and displays it. The program will calculate the average of the numbers in the
 * array, the minimum,
 * the maximum and display it.
 * You can use the method nextInt (n) in java.util.Random to generate an integer
 * in [0,n)
 * 
 * @author Paul P
 */

public class Prog02_02 {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[10];

        // Fill array with random integers in [0, 100]
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101); // nextInt(101) gives [0, 100]
        }

        // Display the array
        System.out.print("Array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();

        // Calculate sum, min, and max
        int sum = 0;
        int min = array[0];
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (array[i] < min) {
                min = array[i];
            }

            if (array[i] > max) {
                max = array[i];
            }
        }

        // Calculate average
        double average = (double) sum / array.length;

        // Display results
        System.out.println("Average: " + average);
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }
}
