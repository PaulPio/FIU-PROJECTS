package src.Q8;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];
        for(int i = 0; i < 20;i++)
            array[i] = 2 * i;
        System.out.print(Arrays.binarySearch(array, 10) + ", " + Arrays.binarySearch(array, 11));
    }
}
