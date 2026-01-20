package src.DF9;
import java.util.*;
public class DF9Q2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Step #1: Store numbers from 1 to 100 in the list.
        for (int i = 1; i <= 100; i++)
            list.add(i);

        // Get an iterator at the beginning of the list.
        ListIterator<Integer> it = list.listIterator();

        // Step #2: Remove every other element (the even numbers).
        while (it.hasNext()) {
            it.next(); // Skip the odd number.
            if (it.hasNext()) {
                it.next(); // Move to the even number.
                it.remove(); // Remove the even number.
            }
        }

        // Step #3: Print the list in increasing order.
        System.out.print("Increasing order of elements: " + list
                + "\nDecreasing order of elements: [");

        // Print the list in decreasing order using the iterator.
        // The iterator is already at the end of the list.
        while (it.hasPrevious()) {
            System.out.print(it.previous());
            if (it.hasPrevious())
                System.out.print(", ");
        }
        System.out.println("]");
    }
}
