package src.DF2.util;

import src.A1.util.Student;

import java.util.Arrays;

// Source code of the program to create the Gradebook object and it's functions
public class Gradebook {

    // Creating variables
    private Students[] listOfStudents; // Variable to store array of students


    public Gradebook(Students[] listOfStudents) {
        /*Constructor of the gradebook object, it will request an array of Students, this means,
        a list of students and their info */

        this.listOfStudents = listOfStudents;
    };

    public void tabulateStudentsInfo(){
        /* Function to print the students info */

        System.out.printf("%-12s\t%-12s\t%-12s\t%-10s%n", "First","Last","PID","Score");

        for(Students student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10d%n", student.getFirstName(), student.getLastName(), student.getPantherID(), student.getScore());
        }

    }



    public double getMinScore(){
        /* Method to get students minimum score */

        // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
        int i = 0, n = listOfStudents.length;
        int [] scores = new int[n]; // new array with the length of the gradebook
        //enhance for loop to get student scores and store it in an array
        for (Students s : listOfStudents) {
            scores[i++] = s.getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        // Obtaining the first element in the array, which should be the minimum one given that the array was sorted
        return scores[0];
    }

    public double  getMaxScore(){
        /* Method to get students maximum score */
        // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
        int i = 0, n = listOfStudents.length;
        int [] scores = new int[n]; // new array with the length of the gradebook
        //enhance for loop to get student scores and store it in an array
        for (Students s : listOfStudents) {
            scores[i++] = s.getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        // Obtaining the last element in the array, which should be the maximum one given that the array was sorted
        return scores[n-1];
    }

   public double calculateAverageScore(){
        /* Method to calcluate the average score of the students grades, it uses a for loop to
        * review the student array, adds the score and at the end, it divides the total score
        * betwen the number of students */
        double avgscore = 0, score = 0;
        for (int i = 0;i < listOfStudents.length; i++ ) {
            score += listOfStudents[i].getScore();
        }
        avgscore = score / listOfStudents.length;
        return avgscore;
   }

    public static String convertToLetterGrade(double score){
        /* Static Method to convert the number grade to a letter grade using ifs statements */
        if(score >= 95){
            return "A";
        }
        if(score >= 90){
            return "A-";
        }
        if(score >= 87){
            return "B+";
        }
        if(score >= 83){
            return "B";
        }
        if(score >= 80){
            return "B-";
        }
        if(score >= 77){
            return "C+";
        }
        if(score >= 70){
            return "C";
        }
        if(score >= 60){
            return "D";
        }
        else {
            return "F";
        }
    }
}
