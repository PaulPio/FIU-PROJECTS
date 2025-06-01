package src.A1.util;
import java.util.*;
// Source code of the program to create the Gradebook object and it's functions
public class Gradebook {

    public Gradebook() {
        /* Constructor of gradebook */
        listOfStudents = new ArrayList();
    }

    // private instance array to store the students
    private ArrayList<Student> listOfStudents;



    public void addStudent (Student s) {
        /* Method to add students to gradebook */
        listOfStudents.add(s);
    }
    public void tabulateScores(){
        /* Method to print the students info */

        System.out.printf("%-12s\t%-12s\t%-12s\t%-10s%n", "First","Last","PID","Score");

        for(Student student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10d%n", student.getFirstName(), student.getLastName(), student.getPid(), student.getGrade().getScore());
        }

    }




   public double calculateAverageScore(){
        /* Method to calcluate the average score of the students grades, it uses an enhacen for loop to
        * review the student array, adds the score and at the end, it divides the total score
        * betwen the number of students */
        double sum = 0;
        for (Student s : listOfStudents) {
            sum += s.getGrade().getScore(); // The s student object uses the method grade to get the Grade object on the student, the uses the getScore to get the numeric score
        }

        return sum / listOfStudents.size(); // sum of all score between the length of the arrayList
   }

   public double calculateMedian(){
        /* Method to calculate the Median of the Students scores */
        int i = 0, n = listOfStudents.size();
        int [] scores = new int[n];
        for (Student s : listOfStudents) {
            scores[i++] = s.getGrade().getScore();
        }
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
               return s.getFirstName() + " " + s.getLastName();
       }
       return ""; // the search for students failed, the method returns an empty string
   }

}

