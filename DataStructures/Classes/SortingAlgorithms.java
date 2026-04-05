import java.util.Random;

/** Implement utilities related with soring algorithms  */
    public class SortingAlgorithms{
        /**
         * Sorts given array using bubblesort algorithm. Array assumed to be full
         * @param lsit give array
         */
        public static void bubblesort(int [] list){
            //sort list in ascending order
            int n=list.length; //get length of list
            for (int i=0;i<n-1;i++){ //outer loop for number of passes
                for (int j=0;j<n-i-1;j++){ //inner loop for comparison
                    if (list[j]>list[j+1]){ //compare adjacent elements
                        //swap list[j] and list[j+1]
                        int temp=list[j];//store list[j] in temp
                        list[j]=list[j+1];//store list[j+1] in list[j]
                        list[j+1]=temp;//store temp in list[j+1]
                    }
                }
            }
        }

        /**
         * Function to sort an array using quicksort recursive method
         * @param list give array
         * @param start low index
         * @param end high index / pivot index
         */
        public static void quicksort(int [] list, int start, int end){
            if ( end <= start ) return;//base case

            int pivot = partition(list, start, end); 
            quicksort(list, start, pivot-1); // sorting left side of final position pivot/end
            quicksort(list, pivot+1, end); // sorting right side of final position pivot/end

        }

        /*
        * Helper function to get the pivot for quicksort and swap places inside the array
        * @param list give array
        * @param start low index
        * @param end high index / pivot index
        */
       public static int partition(int [] list, int start, int end){
        int pivot = list[end]; //pivot is the last element
        int i = start - 1; 
        for (int j = start; j<=end -1 ; j++){
            if (list[j] < pivot){
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }

        i++;

        int temp = list[i];
        list[i] = list[end];
        list[end] = temp;
        
        return i;

        }


        /**
         * function that sorts an array using insertion sort algorithm
         * the sorting algorithm starts by comparing the element at index 1
         * with the one before, if lower continues with index2, if higher,
         * then swaps the elemnet and continues with the next index  
         * @param list array to sort
         */

        public static void insertionsort(int [] list){
            for (int i = 1; i< list.length; i++){
                int temp = list[i];
                int j = i-1; // to compare value left of i

                
                while(j>= 0 && list[j] > temp){
                    list[j+1] = list[j]; // shift element to the right
                    j--;
                }

                list[j+1] = temp;
            }
        }

/**
 * Sorts given array using selection sort algorithm. Array assumed to be full
 * @param list
 */
        public static void selectionSort(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
            }
		}
		
	
        /**
         * Print given array. Array is assumed to be full 
         * @param list give array
         */
        public static void printArray(int [] list){
            //print array
            for (int i=0;i<list.length;i++){ //loop through array
                System.out.print(list[i]+" "); //print element
            }
            System.out.println(); //print newline
        }

        /**
         * Fills a given array with random values in [-2^31, 2^31 -1]
         * @param list give array
         */
        public static void fillRandom(int [] list){
            //fill array with random values
            Random rnd=new Random(); //create random object
            for (int i=0;i<list.length;i++){ //loop through array
                list[i]=rnd.nextInt(50); //fill with random value
            }
        }   

        /** 
         * binary search O(log n), because the the search get divided in half each time
         * 
         * @param list
         * @param x
         * @return
         */
        public static boolean binarySearch(int[] list, int x){
            int low = 0;
            int n = list.length;
            int high = n -1;
            int pivot;

            boolean found = false;

            long startTime = System.nanoTime();

            while(low <= high && !found ){
                pivot = (low + high) / 2;
                if (list[pivot] == x){
                    found = true;
                }
                else{
                    if (x<list[pivot] ){
                        high = pivot - 1;
                    }
                    else{
                        low = pivot + 1;
                    }
                }
            }
            long endTime = System.nanoTime();
            System.out.println("Binary search time: " + (endTime - startTime) + " nanoseconds");
            return found;
        }

        /**
         * sequential search algorithm O(n)
         * @param list
         * @param x
         * @return
         */

        public static boolean sequentialSearch(int[] list, int x){
            boolean found = false;
            int n = list.length;
            long startTime = System.nanoTime();


            for (int i = 0; i < n && !found; i++){
                if (list[i] ==x){
                    found = true;
                }
            }

            long endTime = System.nanoTime();
            System.out.println("Sequential search time: " + (endTime - startTime) + " nanoseconds");
            return found;
        }

    }