package src.DF2.test.B;

class A{

    int x;

    int decreaseCounter(){

        return --x;

    }

    A (int x){

        this.x = x;

    }

}

public class B extends A{

    private int y;

    private int increaseCounter(){

        return ++y;

    }

    public B(int x, int y){

        super(x);

        this.y = y;

    }

    public static void main(String[] args){

        B b = new B(10, 20);

        b.increaseCounter();

        b.decreaseCounter();

        System.out.printf("%d, %d", b.x, b.y);

    }

}