/*
Write a prgram to test hte recursive implementation of the facroial function
*/

public class Prog_17_01{
    public static void main(String[] args)
    {
        System.out.print(factorial(100));
    }

    public static double factorial(double n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            //System.out.println(n * factorial(n - 1));
            return n * factorial(n - 1);
        }
    }
    
}