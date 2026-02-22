/** Implement inserition sort algothithm */
public class Prog_19_02 {
    public static void main(String[] args) {

        int[] list = new int[500000];
        SortingAlgorithms.fillRandom(list);

        // 1. Get start time
        long startTime = System.currentTimeMillis();

        // 2. Run the sort algorithm
        SortingAlgorithms.printArray(list);

        // 3. Get end time
        long endTime = System.currentTimeMillis();

        // 4. Calculate duration
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");
    }

    /**
     * Sorts given array using insertion sort algorithm
     * 
     * @param list
     */
    public static void insertionSort(int[] list) {
        // sort list in ascending order
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i - 1;

            while (j >= 0 && temp < list[j]) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
    }
}
