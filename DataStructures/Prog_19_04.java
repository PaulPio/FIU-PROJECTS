/**
 * Merge list sort algorithm
 */

public class Prog_19_04 {
    public static void main(String[] args) {
        int [] list_1 = new int[10];
        int [] list_2 = new int[10];
        int [] list_3 = new int[list_1.length + list_2.length];

        SortingAlgorithms.fillRandom(list_1);
        SortingAlgorithms.fillRandom(list_2);

        SortingAlgorithms.bubblesort(list_1);
        SortingAlgorithms.bubblesort(list_2);

        SortingAlgorithms.printArray(list_1);
        SortingAlgorithms.printArray(list_2);

        listMerge(list_1, list_2, list_3);

         // 1. Get start time
        long startTime = System.currentTimeMillis();

        // 2. Run the sort algorithm
        SortingAlgorithms.printArray(list_3);

        // 3. Get end time
        long endTime = System.currentTimeMillis();

        // 4. Calculate duration
        long duration = endTime - startTime;
        System.out.println("Duration: " + duration + " milliseconds");

    }

/**
* Merges two sorted array lists to obtain a new sorted list; resulting
* list is stored in an array.
*
* @param list1 input sorted array
* @param list2 input sorted array
* @param list3 output sorted array
*/
public static void listMerge(int[] list1, int[] list2, int[] list3)
{
    int p1 = 0; //pointer to traverse list 1
    int p2 = 0; //pointer to traverse list 2
    int p3 = 0; //pointer to traverse list 3
    while (p1 != list1.length && p2 != list2.length)
    {
        if (list1[p1] < list2[p2])
        {
            list3[p3] = list1[p1];
            p1++;
        }
        else
        {
            list3[p3] = list2[p2];
            p2++;
        }
        p3++;
    }
    if (p1 == list1.length)
    {
        while (p2 != list2.length)
        {
            list3[p3] = list2[p2];
            p2++;
            p3++;
        }
    }
    if (p2 == list2.length)
    {
        while (p1 != list1.length)
        {
            list3[p3] = list1[p1];
            p1++;
            p3++;
        }
    }
    }
    
}