/**
 * Implemetn and test sequntial and binary search methods
 */

public class Program_20_01 {
    public static void main(String[] args) {
        int list [] = {1,2,3,4,5,6,7,8,9,10};
        int list2 [] = new int [100];
        SortingAlgorithms.fillRandom(list2);
        SortingAlgorithms.binarySearch(list2,55);
        SortingAlgorithms.sequentialSearch(list2,55);
    }
}
