package src.util;
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


   public double calculateAverageScore(){
        double avgscore = 0, score = 0;
        for (int i = 0;i < listOfStudents.length; i++ ) {
            score += listOfStudents[i].getScore();
        }
        avgscore = score / listOfStudents.length;
        return avgscore;
   }

    public static String convertToLetterGrade(double score){
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
