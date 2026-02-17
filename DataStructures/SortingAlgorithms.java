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
                list[i]=rnd.nextInt(); //fill with random value
            }
        }   
    }