
public class LinkedList implements ListInterface {

    public class Node {

        private int info;
        private Node next;

        public Node() {
            info = 0;
            next = null;
        }

        public void setInfo(int i) {
            info = i;
        }

        public void setNext(Node l) {
            next = l;
        }

        public int getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node first;

    public LinkedList() {
        first = new Node();
    }

    public boolean isEmpty() {
        return (first.getNext() == null);
    }

    public void display() {
        Node current = first.getNext();

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    public boolean search(int x) {
        Node current = first.getNext();

        while (current != null) {
            if (current.getInfo() == x) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    /*
     * Returns the length of the linked list.
     * 
     * @return the length of the linked list
     */
    public int length() {
        Node current = first.getNext(); // Check for the next node
        int count = 0; // Start the count of items

        while (current != null) { // Loop until the end of the linked list, if no more nodes,
            // exit loop
            count++; // Increment the count
            current = current.getNext(); // Move to the next node
        }

        return count; // Return final count of items
    }

    public void add(int x) {
        Node p = new Node();

        p.setInfo(x);
        p.setNext(first.getNext());

        first.setNext(p);
    }

    public void remove(int x) {
        Node old = first.getNext(),
                p = first;

        boolean found = false;
        while (old != null && !found) {
            if (old.getInfo() == x) {
                found = true;
            } else {
                p = old;
                old = p.getNext();
            }
        }

        if (found) {
            p.setNext(old.getNext());
        }
    }

    /*
     * Inserts an item at a specific location in the linked list.
     * 
     * @param x the item to insert
     * 
     * @param loc the location to insert the item at
     */
    public void insert(int x, int loc) {
        // Check if the location is valid
        if (loc < 0 || loc > length()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            Node p = new Node(); // Create a new node
            p.setInfo(x); // Set the info of the new node
            Node current = first; // Set the current node to the first node
            for (int i = 0; i < loc; i++) { // Loop until the location is reached, if no more nodes, exit loop
                current = current.getNext(); // Move to the next node
            }
            if (current != null) { // Check if the current node is not null
                p.setNext(current.getNext()); // Set the next node of the new node
                current.setNext(p); // Set the next node of the current node
            }
        }

    }

    /*
     * Removes an item at a specific location in the linked list.
     * 
     * @param loc the location to remove the item from
     */
    public void removeItemAt(int loc) {
        // Check if the location is valid
        if (loc < 0 || loc > length()) {// Check if the location is valid
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            Node current = first; // Set the current node to the first node
            for (int i = 0; i < loc && current != null; i++) { // Loop until the location is reached
                current = current.getNext(); // Move to the next node
            }
            if (current != null) { // Check if the current node is not null
                current.setNext(current.getNext().getNext()); // Set the next node of the current node,
                // skipping the node at the specified location, if the node is not null,
                // then set the next node of the current node to the next node of the next node
            }
        }

    }

    /**
     * Returns the first node in the list (the dummy node).
     * 
     * @return the first node
     */
    public Node getFirstNode() {
        return first;
    }
}
