package src.test;

import src.util.*;

public class test {
    public static void main(String[] args) {
        Students first = new Students("A", "B", 5646546, 90);
        Students second = new Students("B", "Y", 4564586, 80);
        Students third = new Students("C", "Q", 5641225, 75);
        Students fourth = new Students("D", "N", 1235467, 65);


        Gradebook myGradeBook = new Gradebook(
                new Students[]{first, second, third, fourth}
        );

      //  System.out.printf("The average grade was %.2f", myGradeBook.calculateAverageScore());

       // double avg = myGradeBook.calculateAverageScore();
     //   System.out.printf("The average letter grade was %.2f", Gradebook.convertToLetterGrade(avg));

    }
}
