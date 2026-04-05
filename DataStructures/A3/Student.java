
/**
 * ASSIGNMENT 3
 * This class represents a student.
 * 
 * @author Prof. A. Hernandez
 */
public class Student
{
    
    private String firstName; //student first name
    private String lastName;  //student last name
    private int ID;           //student ID in the range [0, 10000]
    private char grade;       //student grade: A, B, C, D, F

    /**
     * Default constructor. Sets fields to default values.
     */
    public Student()
    {
        this.firstName = "<N/A>";
        this.lastName = "<N/A>";
        this.ID = -1;
        this.grade = 'I';
    }

    /**
     * Parameterized constructor. Sets fields to values passed by user.
     * 
     * @param firstName student first name
     * @param lastName student last name
     * @param ID student ID in the range [0, 10000]
     * @param grade student grade: A, B, C, D, F
     */
    public Student(String firstName, String lastName, int ID, char grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.grade = grade;
    }

    /**
     * Get the value of grade
     *
     * @return the value of grade
     */
    public char getGrade()
    {
        return grade;
    }

    /**
     * Set the value of grade
     *
     * @param grade new value of grade
     */
    public void setGrade(char grade)
    {
        this.grade = grade;
    }


    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getID()
    {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(int ID)
    {
        this.ID = ID;
    }


    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Sets the values of all fields of this student.
     * 
     * @param firstName student first name
     * @param lastName student last name
     * @param ID student ID in the range [0, 10000]
     * @param grade student grade: A, B, C, D, F
     */
    public void setStudent(String firstName, String lastName, int ID, char grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.grade = grade;
    }

    @Override
    /**
     * Returns a String description of this student.
     * 
     * @return description of this student
     */
    public String toString()
    {
        return String.format("%10s%10s%7d%3c", firstName, lastName, ID, grade);
    }
}
