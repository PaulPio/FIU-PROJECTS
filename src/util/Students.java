package src.util;
// Source code of program to create the Students object
public class Students {
    // Declaring variables for the object attributes
    private String firstName; // Student first name
    private String lastName; // Student last name
    private int pantherID; // Student panther id
    private int score; // Student score

    public String getFirstName() {
        return firstName;
    } //Getter function for first name

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // Set function for first name

    public String getLastName() {
        return lastName;
    } //Getter function for last name

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // Set function for last name

    public int getPantherID() {
        return pantherID;
    } //Getter function for panther id name

    public void setPantherID(int pantherID) {
        this.pantherID = pantherID;
    } // Set function for panther id

    public int getScore() {
        return score;
    } ////Getter function for score name

    public void setScore(int score) {
        this.score = score;
    } // Set function for score

    public Students(String firstName, String lastName, int pantherID, int score) {
        /* Constructor of the Student object, it requests the attributes of the Student to create the object */
        this.firstName = firstName;
        this.lastName = lastName;
        this.pantherID = pantherID;
        this.score = score;
    }
}
