
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ASSIGNMENT 3
 * The class Dictionary implements a dictionary ADT with a binary search tree.
 * The dictionary stores information on students. Precondition: all student ID's
 * are distinct.
 *
 * @author Paul Piotrowski, 6568148, and COP3530 U01 U02 1261
 */
public class Dictionary
{

    private BinarySearchTree bst; //dictionary is stored here, sorted on IDs

    /**
     * Parameterized constructor, reads given textfile with dictionary info into
     * the class variable bst, a binary search tree.
     *
     * @param inputFilename name of input file with dictionary info
     */
    public Dictionary(String inputFilename)
    {
        bst = new BinarySearchTree();

        //read file and store it in the binary search tree
        File file = new File(inputFilename);

        try
        {
            Scanner input = new Scanner(file);

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] tokens = line.split(",");

                //parses the strings
                String firstName = tokens[0];
                String lastName = tokens[1];
                int ID = Integer.parseInt(tokens[2]);
                char grade = tokens[3].charAt(0);

                //defines student and adds it to the binary search tree
                Student s = new Student(firstName, lastName, ID, grade);
                bst.add(s);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Dictionary file not found!");
            System.exit(1);
        }
    }

    /**
     * Adds a new entry (a student) to this dictionary.
     *
     * @param stu student
     */
    public void add(Student stu)
    {
        bst.add(stu); // add a new binary search tree object, which is a student into the dictionary
    }

    /**
     * Given a student ID, replaces the student grade with a new one.
     *
     * @param ID student ID
     * @param grade new grade
     * @return true if change was successful; false otherwise (the value of false
     *         will be returned when the given ID is not found in the dictionary)
     */
    public boolean changeGrade(int ID, char grade)
    {
        return bst.changeGrade(ID, grade);
    }

    /**
     * Finds the number of times the given grade is in the dictionary.
     *
     * @param grade given grade
     * @return number of times the given grade is in the dictionary
     */
    public int countGrade(char grade)
    {
        return bst.countGrade(grade);
    }

    /**
     * Retrieve the information of the student with given ID.
     *
     * @param ID student ID
     * @return student info
     */
    public Student retrieve(int ID)
    {
        return bst.retrieve(ID);
    }

    /**
     * Returns the number of elements in the binary search tree.
     *
     * @return the number of elements in the binary search tree
     */
    public int getNumberOfStudents()
    {
        return bst.getNumberOfStudents();
    }

    /**
     * Determines if this dictionary is empty. The method takes O(1) time.
     *
     * @return true if the dictionary retrieve no elements, false otherwise
     */
    public boolean isEmpty()
    {
        return bst.isEmpty();
    }

    /**
     * Builds a String description of this dictionary.
     *
     * @return String containing the dictionary elements
     */
    public String toString()
    {
        return bst.toString();
    }
}
