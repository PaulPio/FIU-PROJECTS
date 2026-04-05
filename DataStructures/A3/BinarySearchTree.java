
/**
 * ASSIGNMENT 3
 * This class represents a binary search tree storing information on students.
 * Students are sorted by their ID's.
 *
 * @author add here name, Panther ID, and class section of all authors
 */
public class BinarySearchTree
{
    private Node root;    //root of the bst; implemented as a dummy node.

    /**
     * Default constructor. Sets field to a dummy root node.
     */
    public BinarySearchTree()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null);
        root.setRightChild(null);
        root.setInfo(new Student());
    }

    /**
     * Adds a student to the tree.
     *
     * @param stu student
     */
    public void add(Student stu)
    {
        //TO IMPLEMENT
    }

    /**
     * Finds the number of times the given grade is in the tree.
     *
     * @param grade given grade
     * @return number of times the given grade is in the tree
     */
    public int countGrade(char grade)
    {
        //TO IMPLEMENT
    }

    /**
     * Given a student ID, replaces the  student grade with a new one.
     *
     * @param ID student ID
     * @param grade new grade
     * @return true if change was successful; false otherwise
     */
    public boolean changeGrade(int ID, char grade)
    {
        //TO IMPLEMENT
    }

    /**
     * Determines the number of students stored in the tree
     *
     * @return number of students stored in the tree
     */
    public int getNumberOfStudents()
    {
        //TO IMPLEMENT
    }

    /**
     * Determines whether this tree is empty.
     *
     * @return true if tree is empty; false otherwise
     */
    public boolean isEmpty()
    {
        //TO IMPLEMENT
    }

    /**
     * Retrieves the information of the student with the given ID.
     *
     * @param ID ID
     * @return student info
     */
    public Student retrieve(int ID)
    {
        //TO IMPLEMENT
    }

    /**
     * Constructs string description of the students in the tree.
     *
     * @return info of the students in the tree, sorted by ID.
     */
    public String toString()
    {
        return toString(root.getLeftChild());
    }

    /**
     * Adds a student to the subtree with root p. Recursive method.
     *
     * @param stu student
     * @param p root of subtree
     */
    private void add(Student stu, Node p)
    {
        //TO IMPLEMENT
    }

    /**
     * Finds the number of times the given grade is in the tree. Postorder
     * traversal is used. Recursive method.
     *
     * @param grade given grade
     * @param p root of subtree
     * @return number of times the given grade is in the tree
     */
    private int countGrade(char grade, Node p)
    {
        //TO IMPLEMENT
    }

    /**
     * Given a student ID, replace the  student grade with a new one. Recursive
     * method.
     *
     * @param ID student ID
     * @param grade new grade
     * @param p root of subtree
     * @return true if change was successful; false otherwise
     */
    private boolean changeGrade(int ID, char grade, Node p)
    {
        //TO IMPLEMENT
    }

    /**
     * Recursive method that determines the number of students in the given
     * subtree
     *
     * @param p root of subtree
     * @return number of students in the subtree whose root is p
     */
    private int getNumberOfStudents(Node p)
    {
        //TO IMPLEMENT
    }

    /**
     * Retrieves the information of the student with the given ID. Recursive
     * method.
     *
     * @param ID student ID
     * @param p root of subtree where search will occur
     * @return student info
     */
    private Student retrieve(int ID, Node p)
    {
        //TO IMPLEMENT
    }

    /**
     * Constructs string description of the students in the tree. Recursive
     * method.
     *
     * @param p root of subtree
     * @return info of the students in the tree, sorted by ID.
     */
    private String toString(Node p)
    {
        if (p != null)
        {
            return toString(p.getLeftChild())
                    + p.getInfo() + "\n"
                    + toString(p.getRightChild());
        } else
        {
            return "";
        }
    }

}
