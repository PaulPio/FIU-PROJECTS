package src.DF5.Q3;

public class MainClass {
    public static void main(String[] args){
        boolean[] flags = new boolean[] {false, true};
        try {
            if(flags[1] && Integer.parseInt("1.2") >= 1)
                System.out.println("Hello");
            else if(flags[2])
                System.out.println(1/0);
        }catch(NumberFormatException e) {
            System.out.println("first");
        }catch(ArithmeticException e) {
            System.out.println("second");
        }catch(IndexOutOfBoundsException e) {
            System.out.println("third");
        }catch(Throwable t) {
            System.out.println("fourth");
        }finally {
            System.out.println("fifth");
        }

    }
}
