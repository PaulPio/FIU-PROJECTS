package src.A1.util;
/*
    Class Grade to get students grades, both numerical and letter grades
*/

public class Grade {
    // Declaring variables
    private int score; //NUMERICAL GRADE
    private String letterGrade; //LETTER GRADE

    public int getScore() {
        return score; //Getter method for score
    }
    public String getLetterGrade() {
        return letterGrade; //Getter method for letter Grade
    }
    public Grade(int score){
        // Constructor for grade
        this.score = score;
        this.letterGrade = Grade.convertToLetterGrade(score);/**/
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
