package src.A1.util;

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
        /* Method to print the students info */

        System.out.printf("%-12s\t%-12s\t%-12s\t%-10s%n", "First","Last","PID","Score");

        for(Students student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10d%n", student.getFirstName(), student.getLastName(), student.getPid(), student.getGrade());
        }

    }


   public double calculateAverageScore(){
        /* Method to calcluate the average score of the students grades, it uses a for loop to
        * review the student array, adds the score and at the end, it divides the total score
        * betwen the number of students */
        double avgscore = 0, score = 0;
        for (int i = 0;i < listOfStudents.length; i++ ) {
            score += listOfStudents[i].getGrade();
        }
        avgscore = score / listOfStudents.length;
        return avgscore;
   }


}
