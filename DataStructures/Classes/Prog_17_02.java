/*
Write a prgram to test hte recursive implementation of the facroial function
*/

public class Prog_17_02{
    public static void main(String[] args)
    {
        //System.out.print(factorial(100));
        System.out.println(problem(5));

        for (int i = 0; i < 50; i++)
        {
            System.out.println(i + " : " + fibonnaci(i));
        }

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
    

    public static double problem(double n){
        //double a = 5;
        if (n == 0)
        {
            //System.out.println(1);
            return 5;
        }
        else
        {
            return 2 * problem(n - 1) + 3;
            //System.out.println(solution);

        }   
    }

    public static double fibonnaci(double n){
        if (n == 0 || n == 1)
        {
            return n;
        }
        else
        {
            return fibonnaci(n - 1) + fibonnaci(n - 2);
        }
    }
}