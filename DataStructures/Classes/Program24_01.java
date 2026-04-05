public class Program24_01 {
    public static void main(String[] args) {
        /*
        Testing implementation
        */
        //int list1 [] = new int [5];

        int list2 [] = new int [5];
        SortingAlgorithms.fillRandom(list2);
        heapSort(list2);
        SortingAlgorithms.printArray(list2);

        SortingAlgorithms.printArray(heapSort(list2));
    }

    /**
     * Implement the heap sort algo
     */
    public static int [] heapSort(int[] arr){
        int[]sortedArray = new int[arr.length];
        Heap heap = new Heap();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            sortedArray[i] = heap.min();
            heap.removeMin();
        }
        return sortedArray;
    }
}
