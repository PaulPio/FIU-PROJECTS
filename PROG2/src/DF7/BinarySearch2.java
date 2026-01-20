package src.DF7;

public class BinarySearch2 {
    public static int binarySearch (Comparable[] array, Comparable target){//returns the index of array cell that contains target or -1 if not found

        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (int) (low / 2.0 + high / 2.0);
            int comp = target.compareTo(array[mid]);

            if (comp == 0) {
                if (mid == 0 || !array[mid-1].equals(array[mid]))
                    return mid;
                else
                    high = mid - 1;
            }
            if (comp > 0)   low = mid + 1;
            else    high = mid - 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        Comparable[] array = {1, 2, 2, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(binarySearch(array,2));
    }
}
