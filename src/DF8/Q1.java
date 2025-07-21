package src.DF8;

public class Q1 {

    /* Calculates the nth element of the sequence g defined by:
     * g_0 = 0, g_1 = 1, g_2 = 1
     * g_n = g_{n-1} + g_{n-2} + g_{n-3} for n >= 3
     *
     * @param n The index of the element to calculate (non-negative integer).
     * @return The nth element of the sequence g.
     */
    public static int fib2(int n){

        // Base case: If n is 0, the result is 0.
        if (n == 0)
            return 0;

        // Base cases: If n is 1 or 2, the result is 1.
        if(n == 1 || n == 2)
            return 1;

        // Recursive step: For n >= 3, g(n) is the sum of the previous three elements.
        return fib2(n-1)+fib2(n-2)+fib2(n-3);
    }
    public static void main(String[] args) {
        System.out.println(fib2(5));


    }
}
