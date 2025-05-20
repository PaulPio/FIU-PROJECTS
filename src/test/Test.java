package src.test;

import src.util.*;

// Program to run the Gradebook functions

public class Test {
    public static void main(String[] args) {

        // Creating Students objects for the Gradebook array
        Students first = new Students("A", "B", 5646546, 90);
        Students second = new Students("B", "Y", 4564586, 80);
        Students third = new Students("C", "Q", 5641225, 75);
        Students fourth = new Students("D", "N", 1235467, 65);

        // Initializing the gradebook array with the list of students and their info
        Gradebook myGradeBook = new Gradebook(
                new Students[]{first, second, third, fourth}
        );

        //Print student info
        myGradeBook.tabulateStudentsInfo();

        // variable to store the average score of the students
        double avg = myGradeBook.calculateAverageScore();

        //Print average grade
        System.out.printf("The average grade was %.2f%n", avg);

        //Print average letter grade
        System.out.printf("The average letter grade was %s",Gradebook.convertToLetterGrade(avg));



    }
}
