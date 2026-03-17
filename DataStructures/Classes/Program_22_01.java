public class Program_22_01 {
    public static void main(String[] args) {
        new Program_22_01();
    }

    Program_22_01() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);
        bst.add(1); 
        bst.add(1); 

        bst.display();
        System.out.println(bst.getMin());
        System.out.println(bst.contains(10));
        System.out.println(bst.contains(20));
        bst.display();
        bst.preorderDisplay();
        bst.postorderDisplay();
        System.out.println(bst.getHeight());
        System.out.println(bst.toString());

        System.out.println(bst.getCount());

        System.out.println(bst.count(80));
        System.out.println(bst.getMax());


    }
}