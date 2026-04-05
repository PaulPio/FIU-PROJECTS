/**
* @author Prof. Hernandez
* Data Structures and Algorithms
*/
public class Node
{

    private Student info;     //element stored in this node
    private Node left;    //link to left child
    private Node right;   //link to right child

    /**
     * Default constructor. Sets fields to default values.
     */
    Node()
    {
        info = new Student();
        left = right = null;
    }

    /**
     * Sets the values of all fields of this node.
     * 
     * @param stu student
     * @param l left child
     * @param r right child
     */
    void setNode(Student stu, Node l, Node r)
    {
        info.setStudent(stu.getFirstName(), stu.getLastName(), stu.getID(), stu.getGrade());
        left = l;
        right = r;
    }

    /**
     * Gets this student.
     * 
     * @return student info
     */
    Student getInfo()
    {
        return info;
    }

    /**
     * Gets the left child.
     * 
     * @return left child
     */
    Node getLeftChild()
    {
        return left;
    }

    /**
     * Gets the right child.
     * 
     * @return right child
     */
    Node getRightChild()
    {
        return right;
    }

    /**
     * Sets this student.
     * 
     * @param stu student info
     */
    void setInfo(Student stu)
    {
        info = stu;
    }

    /**
     * Sets left child.
     * 
     * @param l left child 
     */
    void setLeftChild(Node l)
    {
        left = l;
    }

    /**
     * Sets right child
     * 
     * @param r right child
     */
    void setRightChild(Node r)
    {
        right = r;
    }
}
