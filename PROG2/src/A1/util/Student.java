package src.A1.util;
// Source code of program to create the Students object
public class Student {

    // Declaring variables for the object attributes
    private String firstName; // Student first name
    private String lastName; // Student last name
    private int pid; // Student panther id
    private Grade grade; // Student grade

    public String getFirstName() {
        return firstName;
    } //Getter Method for first name


    public String getLastName() {
        return lastName;
    } //Getter Method for last name


    public int getPid() {
        return pid;
    } //Getter Method for panther id name


    public Grade getGrade() {
        return grade; //Getter Method for Grade
    }

    public void setGrade(Grade grade) {
        this.grade = grade; //Set Method for Grade
    }

    public Student(String firstName, String lastName, int pid, Grade grade) {
        /* Constructor of the Student object, it requests the attributes of the Student to create the object */
        this.firstName = firstName;
        this.lastName = lastName;
        this.pid = pid;
        this.grade = grade;
    }
}
