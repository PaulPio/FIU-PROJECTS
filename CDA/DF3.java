package CDA;

public class DF3 {
    public static void main(String[] args) {
        printSumDiff(2147483647, 150);
    }

    static void printSumDiff(int op1, int op2) {
    int sum = op1 + op2;
    int diff = op1 - op2;

    // Addition Overflow Check
    // (op1 ^ sum) & (op2 ^ sum) checks if op1 and op2 have the same sign, 
    // AND if the sum has a different sign.
    if (((op1 ^ sum) & (op2 ^ sum)) < 0) {
        throw new ArithmeticException("Addition overflow/underflow occurred.");
    }

    // Subtraction Overflow Check
    // (op1 ^ op2) & (op1 ^ diff) checks if op1 and op2 have opposite signs, 
    // AND if the difference has a different sign than op1.
    if (((op1 ^ op2) & (op1 ^ diff)) < 0) {
        throw new ArithmeticException("Subtraction overflow/underflow occurred.");
    }

    System.out.println("Sum: " + sum);
    System.out.println("Difference: " + diff);
    }
}
