package src.DF7;

public class BinarySearchAlgorithm {
    private static boolean  helper(Comparable[] array, Comparable target, int left, int right){
        if(left > right)//search space is empty
            return false;//unsuccessful search
        int midIndex = left + (right - left) / 2;//(left + right)/2;
        int compResult = target.compareTo(array[midIndex]);
        if(compResult == 0)//success!
            return true;
        if(compResult > 0)
            return helper(array, target, midIndex + 1, right);
        else
            return helper(array, target, left, midIndex - 1);
    }
    public static boolean binarySearch(Comparable[] array, Comparable target){
        return helper(array, target, 0, array.length-1);
    }

    public static void main(String[] args) {
        Comparable[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        binarySearch(array,13);
    }
}
