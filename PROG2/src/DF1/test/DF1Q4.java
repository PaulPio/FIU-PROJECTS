package src.DF1.test;
//Write a Java program that stores the content of the following table in a twoD array of integer

public class DF1Q4 {
    public static void main(String[] args) {
        int listOfNumbers[][] = {
                {1, 6, 11, 16, 21},
                {2, 7, 12, 17, 22},
                {3, 8, 13, 18, 23},
                {4, 9, 14, 19, 24},
                {5, 10, 15, 20, 25}
        };


        // For loop that iterates over the elements of the array
        //The first loop iterates over the rows, the inner loop over the columns
        for (int i = 0; i < listOfNumbers.length; i++) {

            for (int j = 0; j < listOfNumbers[i].length; j++) {

                //Printing the elements of the columns separated by a tab
                System.out.print(listOfNumbers[i][j] + "\t");

            }
            // Printing a new line after the columns
            System.out.println();
        }
    }
}
