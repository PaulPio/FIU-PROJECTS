package src.A1.util;
import java.util.*;

import static src.A1.util.Grade.convertToLetterGrade;

// Source code of the program to create the Gradebook object and it's functions
public class Gradebook {

    public Gradebook() {
        /* Constructor of gradebook */
        listOfStudents = new ArrayList<>();
    }

    // private instance array to store the students
    private ArrayList<Student> listOfStudents;



    public boolean isEmpty() {
        /*
          Checks if the gradebook is empty.
          return true if there are no students, false otherwise.
         */
        if (listOfStudents.isEmpty()) {
            System.out.println("No students in the gradebook.");
        }
        return listOfStudents.isEmpty();
    }
    public void addStudent (Student student, int givenID) {
        /* Method to add students to gradebook */

        // Check for duplicate PIDs if necessary
         for (Student s : listOfStudents) {
            if (s.getPid() == givenID) {
                System.out.println("Error: Student with PID " + givenID + " already exists.");
                return;
            }
         }
        listOfStudents.add(student);
    }
    public void tabulateScores(){
        /* Method to print the students info */

        // Display the titles of the table properly tabbed
        System.out.printf("%-12s\t%-12s\t%-12s\t%-10s%n", "First","Last","PID","Score");

        // Enhanced for loop to goes through the array student per student displaying all the request info using the get methods
        for(Student student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10d%n", student.getFirstName(), student.getLastName(), student.getPid(), student.getGrade().getScore());
        }

    }

    public void tabulateLetterGrade(){
        /* Method to print the students info with the letter grade */

        // Display the titles of the table properly tabbed
        System.out.printf("%-12s\t%-12s\t%-12s\t%-10s%n", "First","Last","PID","Letter Grade");
        // Enhanced for loop to goes through the array student per student displaying all the request info using the get methods
        for(Student student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10s%n", student.getFirstName(), student.getLastName(), student.getPid(), student.getGrade().getLetterGrade());
        }

    }

   public double calculateAverageScore(){
        /* Method to calculate the average score of the students grades, it uses an enhanced for loop to
        * review the student array, adds the score and at the end, it divides the total score
        * between the number of students */


        // Declaring local variable sum
        double sum = 0;
        for (Student s : listOfStudents) {

            // The s student object uses the method grade to get the Grade object on the student, them uses the getScore to get the numeric score
            sum += s.getGrade().getScore();
        }
        // sum of all score between the length of the arrayList
        return sum / listOfStudents.size();
   }

    public String calculateAverageLetterGrade(){
        /* Method to calculate the average Letter Grade of the students grades, it uses an enhanced for loop to
         * review the student array, adds the score and at the end, it divides the total score
         * between the number of students */

        // Declaring local variable sum
        double sum = 0;
        for (Student s : listOfStudents) {

            // The s student object uses the method grade to get the Grade object on the student, the uses the getScore to get the numeric score
            sum += s.getGrade().getScore();
        }

        // sum of all score between the length of the arrayList , then will use the convertToLetterGrade to get the letter grade of teh average score
        return convertToLetterGrade( sum / listOfStudents.size()) ;
    }

   public double calculateMedianScore(){
        /* Method to calculate the Median of the Students scores */
        int i = 0, n = listOfStudents.size();
        int [] scores = new int[n]; // Array withe lenght of the number of students in gradebook
       //Enhance for loop to go through the students in the gradebook and add their scores in int array
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        if (n % 2 == 0)
            return (scores [n/2]+scores[n/2-1])/2.0;
        else
            return scores[n/2];
   }

   public String getFullName(int givenID){
        /* Method to get full name of student using the Panther ID*/
       for (Student s : listOfStudents) {
           if (s.getPid() == givenID)
               // If ID is found in array, prints the full name of student
               return "The full name is " + s.getFirstName() + " " + s.getLastName();
       }
       return "Wrong information, try again\n"; // the search for students failed, the method returns an error message
   }

   public String changeGrade(int givenID, Grade newGrade){
        /* Method to change the student grade */
       // Enhance for loop that check for PID that matches one in the gradebook,
       // If it finds one, then it will update the grade to the new grade
       for (Student s : listOfStudents) {
           if (s.getPid() == givenID) {
               s.setGrade(newGrade);
               return "Grade changed to " + newGrade.getScore();
           }
       }
       return "Wrong information, try again\n"; // the search for students failed, the method returns an error message
   }

   public double getMinScore(){
        /* Method to get students minimum score */

       // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
       int i = 0, n = listOfStudents.size();
       int [] scores = new int[n]; // new array with the length of the gradebook
       //enhance for loop to get student scores and store it in an array
       for (Student s : listOfStudents) {
           scores[i++] = s.getGrade().getScore();
       }
       // sorting the scores in the array
       Arrays.sort(scores);
       // Obtaining the first element in the array, which should be the minimum one given that the array was sorted
       return scores[0];
   }

    public double getMaxScore(){
        /* Method to get students maximum score */
        // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
        int i = 0, n = listOfStudents.size();
        int [] scores = new int[n]; // new array with the length of the gradebook
        //enhance for loop to get student scores and store it in an array
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        // Obtaining the last element in the array, which should be the maximum one given that the array was sorted
        return scores[n-1];
    }

    public String getMaxLetter() {
        /* Method to get students maximum letter grade */
        // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
        int i = 0, n = listOfStudents.size();
        int [] scores = new int[n]; // new array with the length of the gradebook
        //enhance for loop to get student scores and store it in an array
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        // Obtaining the last element in the array, which should be the maximum one given that the array was sorted
        return convertToLetterGrade(scores[n-1]);
    }

    public String getMinLetter() {
        /* Method to get students minimum letter grade */

        // declaring variables, i is used for the for loop, n is to get the length of the gradebook array
        int i = 0, n = listOfStudents.size();
        int [] scores = new int[n]; // new array with the length of the gradebook
        //enhance for loop to get student scores and store it in an array
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
        // sorting the scores in the array
        Arrays.sort(scores);
        // Obtaining the first element in the array, which should be the minimum one given that the array was sorted
        return convertToLetterGrade(scores[0]);
    }

}

