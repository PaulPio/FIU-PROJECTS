public class Prog22_01 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Check if list is empty: " + list.isEmpty());

        System.out.println("Adding numbers 0 to 9 to the list...");
        for (int i = 0; i < 10; i++) {
            list.add((int)(Math.random()*10));
        }

        System.out.println("Display new list: ");
        list.display();
        
        int searchVal = 9;
        System.out.println("Searching for " + searchVal + ": " + list.search(searchVal));


        System.out.println("Removing 5...");
        list.remove(5);
        System.out.print("After removing 5: ");
        list.display();

        System.out.println("Inserting 100 at index 2...");
        list.insert(100, 2);
        System.out.print("After inserting 100: ");
        list.display();

        System.out.println("Removing item at index 0...");
        list.removeItemAt(0);
        System.out.print("After removing item at index 0: ");
        list.display();
       
    }
}
