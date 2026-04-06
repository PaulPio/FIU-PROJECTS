
/**
 * ASSIGNMENT 3
 * This class represents a binary search tree storing information on students.
 * Students are sorted by their ID's.
 *
 * @author Paul Piotrowski, 6568148, and COP3530 U01 U02 1261
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
     * @param stu the student object to be added to the tree
     */
    public void add(Student stu)
    {
        // Check if the tree is currently empty (the dummy root's left child is null)
        if (root.getLeftChild() == null) {
            // Create a new node for the student
            Node n = new Node();
            n.setNode(stu, null, null);
            
            // Set this new node as the first real node of the tree (left child of the dummy root)
            root.setLeftChild(n);
        } else {
            // If the tree already has nodes, delegate to the recursive add method starting at the real root
            add(stu, root.getLeftChild());
        }
    }

    /**
     * Finds the number of times the given grade is in the tree.
     *
     * @param grade given grade
     * @return number of times the given grade is in the tree
     */
    public int countGrade(char grade)
    {
        return countGrade(grade, root.getLeftChild());
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
        return changeGrade(ID, grade, root.getLeftChild());
    }

    /**
     * Determines the number of students stored in the tree
     *
     * @return number of students stored in the tree
     */
    public int getNumberOfStudents()
    {
        return getNumberOfStudents(root.getLeftChild());
    }

    /**
     * Determines whether this tree is empty.
     *
     * @return true if tree is empty; false otherwise
     */
    public boolean isEmpty()
    {
        return root.getLeftChild() == null;
    }

    /**
     * Retrieves the information of the student with the given ID.
     *
     * @param ID ID
     * @return student info
     */
    public Student retrieve(int ID)
    {
        return retrieve(ID, root.getLeftChild());
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
        // Compare the new student's ID with the current node's student ID
        if (stu.getID() < p.getInfo().getID()) {
            
            // If the ID is less, we traverse to the left subtree
            if (p.getLeftChild() == null) {
                // Base case: we found an empty spot! 
                // Create a new node and link it as the left child
                Node n = new Node();
                n.setNode(stu, null, null);
                p.setLeftChild(n);
            } else {
                // Recursive step: keep traversing down the left subtree
                add(stu, p.getLeftChild());
            }
            
        } else if (stu.getID() > p.getInfo().getID()) {
            
            // If the ID is greater, we traverse to the right subtree
            if (p.getRightChild() == null) {
                // Base case: we found an empty spot!
                // Create a new node and link it as the right child
                Node n = new Node();
                n.setNode(stu, null, null);
                p.setRightChild(n);
            } else {
                // Recursive step: keep traversing down the right subtree
                add(stu, p.getRightChild());
            }
            
        }
        // Note: If stu.getID() == p.getInfo().getID(), we do nothing.
        // The precondition assumes all student IDs are distinct, so duplicates shouldn't happen.
    }

    /**
     * Finds the number of times the given grade is in the tree. Postorder
     * traversal is used. Recursive method.
     *
     * @param grade The grade to count.
     * @param p The current node in the subtree being searched.
     * @return The number of times the grade appears in the subtree.
     */
    private int countGrade(char grade, Node p)
    {
        // Base case: if the node is null, there are 0 matches in this empty subtree
        if (p == null) return 0;
        
        // Recursively count the matches in both the left and right subtrees
        int count = countGrade(grade, p.getLeftChild()) + countGrade(grade, p.getRightChild());
        
        // If the current node matches the target grade, increment our total count
        if (p.getInfo().getGrade() == grade) {
            count++;
        }
        
        // Return the total count from the subtrees plus the current node if it matched
        return count;
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
        // Base case: if we reach a null node, the student ID is not in this subtree
        if (p == null) return false;
        
        // If the current node matches the target student ID, update their grade
        if (ID == p.getInfo().getID()) {
            p.getInfo().setGrade(grade);
            return true;
        } 
        // If the target ID is smaller, recursively search the left subtree
        else if (ID < p.getInfo().getID()) {
            return changeGrade(ID, grade, p.getLeftChild());
        } 
        // If the target ID is larger, recursively search the right subtree
        else {
            return changeGrade(ID, grade, p.getRightChild());
        }
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
        // Base case: an empty subtree contains 0 students
        if (p == null) return 0;
        
        // Return 1 (the current node) plus the recursively counted students in left and right subtrees
        return 1 + getNumberOfStudents(p.getLeftChild()) + getNumberOfStudents(p.getRightChild());
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
        // Base case: if node is null, the student is not in the tree
        if (p == null) return null;
        
        // If the current node matches the target student ID, return its data
        if (ID == p.getInfo().getID()) return p.getInfo();
        
        // If the target ID is smaller, recursively search the left subtree
        if (ID < p.getInfo().getID()) return retrieve(ID, p.getLeftChild());
        
        // If the target ID is larger, recursively search the right subtree
        return retrieve(ID, p.getRightChild());
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
        // If the current node exists, perform an in-order traversal (Left, Root, Right)
        if (p != null)
        {
            // 1. Get ordered left child string
            // 2. Append current node
            // 3. Get ordered right child string
            return toString(p.getLeftChild())
                    + p.getInfo() + "\n"
                    + toString(p.getRightChild());
        } else
        {
            // Base case: An empty subtree contributes nothing to the string
            return "";
        }
    }

}
