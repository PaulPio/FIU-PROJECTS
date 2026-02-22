/**
 * Selections sort mehtod
 * for i = 0,1,,2 ... list lenght -1:
 * at iteration i, find the i-th smallest number 
 * and place it in location i
 * complexity n^2
 * 
 */
public class Prog_19_03 {
    public static void main(String[] args) {
        
    }

    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int min = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[min]) {
                    min = j;
                }
            }
            int temp = list[min];
            list[min] = list[i];
            list[i] = temp;
        }   
    }
}
