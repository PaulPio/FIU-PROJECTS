
/**
 * Implement a recursive function that counts the number of elements in a linked
 * list using the program 13_01.java as reference
 */

public class Program_17_05 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(countElements(list.getFirstNode().getNext()));
    }

    /**
     * Implement the recursive function that counts the number of elements in a
     * linked list
     * 
     * @param node
     * @return
     */
    private static int countElements(LinkedList.Node node) {
        // Base case
        if (node == null) {
            return 0;
        }
        // Recursive case
        return 1 + countElements(node.getNext());
    }
}