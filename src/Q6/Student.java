package src.Q6;

import java.util.*;

public class Student {
    public static void main(String[] args) {
        Scanner scnr = new Scanner("8, 3.4, 1.3, 12, 4.0, 5, 6, 7, 1, 2");
        scnr.useDelimiter("[, .]+");//The delimiter is set to any combination of space, comma and dot
        while(scnr.hasNext()) {
            try {

                int dividend = scnr.nextInt(), divisor = scnr.nextInt();
                System.out.println(dividend + " / " + divisor + " = " + (dividend / divisor));
            }catch(InputMismatchException e) {//If nextInt cannot scan an integer!
                scnr.next();//skip the non-integer token
                continue;
            }catch(Exception e) {
                System.out.println("Something went wrong!");
                System.exit(1);//terminate the program.
            }
        }
    }

}