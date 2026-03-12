/**
* @author A. Hernandez
* Data Structures and Algorithms
*/
public class BinarySearchTree
{
    public BinarySearchTree()
    {
        root = new Node();        //dummy node as the root
        root.setLeftChild(null); // setting left child to null
        root.setRightChild(null); // setting right child to null
        root.setInfo(-1); // setting info to -1
    }

    /*
    * Function that checks if the node is empty
     */
    public boolean isEmpty()
    {
        return root.getLeftChild() == null;
    }

    public void display()
    {
        inorderDisplay(root.getLeftChild());
        System.out.println();
    }

    public void preorderDisplay()
    {
        preorderDisplay(root.getLeftChild());
        System.out.println();
    }

    public void postorderDisplay()
    {
        postorderDisplay(root.getLeftChild());
        System.out.println();
    }

    public boolean contains(int x)
    {
        return search(x, root.getLeftChild());
    }

    public void add(int x)
    {
        if (root.getLeftChild() == null)
        {
            Node p = new Node();
            p.setNode(x, null, null);
            root.setLeftChild(p);
        } else
            insert(x, root.getLeftChild());
    }

    public int getMin()
    {
        return getMin(root);
    }

    private Node root;    //root of the bst; implemented as a dummy node.

    /**
     * Function to display the nodes inorder
     * @param p Node to be displayed in inorder
     */
    private void inorderDisplay(Node p)
    {
        if (p != null)
        {
            inorderDisplay(p.getLeftChild());
            System.out.print(p.getInfo() + " ");
            inorderDisplay(p.getRightChild());
        }
    }

    /**
     * Function to display the nodes in preorder
     * @param p Node to be displayed in preorder
     */
    private void preorderDisplay(Node p)
    {
        if (p != null)
        {
            System.out.print(p.getInfo() + " ");
            preorderDisplay(p.getLeftChild());
            preorderDisplay(p.getRightChild());
        }
    }

    /**
     * Function to display the nodes in postorder
     * @param p Node to be displayed in postorder
     */
    private void postorderDisplay(Node p)
    {
        if (p != null)
        {
            postorderDisplay(p.getLeftChild());
            postorderDisplay(p.getRightChild());
            System.out.print(p.getInfo() + " ");
        }
    }

    /**
     * 
     * Function to search for a node in the tree
     * @param x Node to be searched
     * @param p Node to be searched in
     * @return true if the node is found, false otherwise
     */
    private boolean search(int x, Node p)
    {
        if (p == null)
            return false;
        else if (x == p.getInfo())
            return true;
        else if (x < p.getInfo())
            return search(x, p.getLeftChild());
        else
            return search(x, p.getRightChild());
    }

    private void insert(int x, Node p)
    {
        if (x < p.getInfo())
            if (p.getLeftChild() == null)
            {
                Node q = new Node();
                q.setNode(x, null, null);
                p.setLeftChild(q);
            } else
                insert(x, p.getLeftChild());
        else if (p.getRightChild() == null)
        {
            Node q = new Node();
            q.setNode(x, null, null);
            p.setRightChild(q);
        } else
            insert(x, p.getRightChild());
    }

    /**
     * gettining minium value of the node throuhg recursion
     * @param p
     * @return
     */
    private int getMin(Node p)
    {
        if (p.getLeftChild() == null)
            return p.getInfo();
        else
            return getMin(p.getLeftChild());
    }

    /**
     * Function to convert the tree to a string
     * @param p Node to be converted to a string
     * @return String representation of the tree
     */
    private String toString(Node p)
    {
        String s = "";
        if (p != null)
        {
            return toString(p.getLeftChild()) + p.getInfo() + " " +  toString(p.getRightChild()) ;
        }
        else
            return s;
    }

    /*
     * Function to get the height of the tree
     * @return height of the tree
     */
    public int getHeight(){
        return getHeight(root.getLeftChild());
    }

    /**
     * Function to get the height of the tree
     * @param p Node to be checked
     * @return height of the tree
     */
    public int getHeight(Node p){
        if (p == null)
            return -1;
        else
            return 1 + Math.max(getHeight(p.getLeftChild()), getHeight(p.getRightChild()));
    }
}
