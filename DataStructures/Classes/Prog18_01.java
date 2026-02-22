import java.util.Date;
import java.util.Random;
public class Prog18_01
    {
    /**
    * Determines the smallest (minimum) value in given array.
    *
    * @param a given array
    * @param n number of elements stored in array
    * @return minimum
    */
        int minimum(int a[], int n)
    {
        int min = a[0];
        for (int i = 1; i < n; i++)
        if (min > a[i]) min = a[i];
        return min;
    }
    public Prog18_01()
    {
        int[] a = new int[100000000];
        //populates array with random numbers
        Random rnd = new Random();
        for (int i = 0; i < a.length; i++)
        {
            a[i] = rnd.nextInt();
        }
        //times the method that finds the minimum
        Date current = new Date();
        long start = current.getTime();
        int min = minimum(a, a.length);
        current = new Date();
        long stop = current.getTime();
        //prints time taken by the minimum method
        System.out.println("\nMin = " + min + ", time = " + (stop-start));
    }
    public static void main(String[] args)
    {
        new Prog18_01();
    }
}