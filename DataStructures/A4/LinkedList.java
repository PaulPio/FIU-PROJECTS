
/**
 * The class LinkedList implements a singly linked list of strings.
 * The list uses a header (dummy) node.
 *
 * @author Paul Piotrowski, 6568148, 1261 - COP3530 - & Data Structures - Sections U01 & U02 
 */
public class LinkedList
{
    /**
     * Implements the node of a singly linked list of string type.
     */
    private class Node
    {
        private String info;
        private Node next;

        public Node()
        {
            info = "<empty>";
            next = null;
        }

        public String getInfo()
        {
            return info;
        }

        public Node getNext()
        {
            return next;
        }

        public void setInfo(String info)
        {
            this.info = info;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }
    }

    private final Node first; //dummy header node

    /**
     * Default constructor. Sets this object as an empty list.
     */
    public LinkedList()
    {
        first = new Node();
    }

    /**
     * Adds given string as the first element of the list.
     *
     * @param str given string
     */
    public void add(String str)
    {
        //creating a new node 
        Node newNode = new Node();
        // setting the info attribute of the new node
        newNode.setInfo(str);
        //set newNode next to the next of first
        newNode.setNext(first.getNext());
        // setting the new node as next of the first dummy node
        first.setNext(newNode);
    }

    /**
     * Determines if linked list is empty.
     *
     * @return true if list contains no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        // if item next to the first or dummny node is null, then list is empty, return true, else, return false
        if (first.getNext() == null) 
            return true;
        else 
            return false;
    }

    /**
     * Removes given string from the list.
     *
     * @param str string to be removed
     */
    public void remove(String str)
    {
        Node current = first; // create a new current node
        //while current is true, this means, while current has a value and is not null, if the target is found, break the loop
        while (current.getNext() != null){ 
            if (current.getNext().getInfo().equals(str)){
                current.setNext(current.getNext().getNext());
                break;
            }
            // if target not found, continue to update current to get until the end of the list
            current = current.getNext();
        }
       
    }

    /**
     * Determines if given string is in the list.
     *
     * @param str given string
     * @return true if str is in the list, false otherwise
     */
    public boolean search(String str)
    {
        Node current = first.getNext(); // create a new current node
        while (current != null){ //while current is true, this means, while current has a value and is not null
            if (current.getInfo().equals(str))
                return true;
            // if target not found, continue to update current to get until the end of the list
            current = current.getNext();
        }
        
        return false;
    }

    /**
     * Constructs a String description of the list.
     *
     * @return String containing the list elements.
     */
    public String toString()
    {
        Node current = first.getNext();

        String str = "";
        while (current != null)
        {
            str += "[" + current.getInfo() + "]";
            current = current.getNext();

            if (current != null)
                str += " -> ";
        }

        return str;
    }
}
