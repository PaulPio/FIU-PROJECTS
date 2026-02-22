
public class Prog16_02 {

    public static void main(String[] args) {
        Queue q = new Queue();

        System.out.println("Item at the front: " + q.getFront());

        // Insertion
        for (int i = 0; i < 10; i++) {
            int x = 32 + (int) (Math.random() * 95);
            System.out.println(x + " --> " + (char) x);
            q.enqueue((char) x);
        }

        q.display();
        // Display and removal
        while (!q.isEmpty()) {
            System.out.println("Item at the front: " + q.getFront());

            System.out.println("Count: " + q.getCount());

            q.dequeue();
        }

        q.display();


    }
}
