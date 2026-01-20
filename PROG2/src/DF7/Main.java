package src.DF7;

public class Main {
    public static void f(int n){

        if(n == 0)

            System.out.print("base\n");

        else {

            System.out.println("before " + n);

            f(n - 1);

            System.out.println("after " + n);

        }

    }

    public static void main(String[] args){

        f(3);//place a breakpoint here

    }
}
