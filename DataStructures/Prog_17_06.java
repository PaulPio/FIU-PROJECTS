/**
 * Write a recursrsive method that returns the smallest number in an array of integers
 * 
 * Susgestions
 * Compare the first element of the array with the smallest number found recursively in the rest of the aaray
 * What is the time complexity of this algorithm?
 */

public class Prog_17_06 {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 0, 5};
        System.out.println(smallestNumber(list, 0));
    }

    /**
     * Returns the smallest number in an array of integers
     * @param list
     * @param index
     * @return
     */
    public static int smallestNumber(int[] list, int index) {
        // Base case
        if (index == list.length) {
            return list[list.length - 1];
        }
        // Recursive case
        int smallest = smallestNumber(list, index + 1);
        return Math.min(list[index], smallest);
    }
}
