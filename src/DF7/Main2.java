package src.DF7;

public class Main2 {
    public static void g(int n, int b){

        if(n < b)

            System.out.print(n);

        else {



            g(n/b, b);//line 7

            System.out.print(n%b);//line 6

        }

    }

    public static void main(String[] args){

        g(85649, 10);

    }
}
