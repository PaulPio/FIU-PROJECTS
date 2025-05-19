package src.util;

public class Gradebook {
    private Students[] listOfStudents;

    public Gradebook(Students[] listOfStudents) {
        this.listOfStudents = listOfStudents;
    };

    public void tabulateStudentsInfo(){
        System.out.println("First\tLast\tPID\tScore");

        for(Students student : listOfStudents){
            System.out.printf("%-12s\t%-12s\t%-12d\t%-10d");
        }

    }


   // public double calculateAverageScore(){

  //  }

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
