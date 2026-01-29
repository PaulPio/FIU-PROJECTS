/*
Implemntation provided does not take care of incorrect 
use of the Stack method (push, pop, peek)
fix it

Now modify the push to always push no mather
*/


public class Prog15_02 {

    private char[] list;
    private int size;
    private int top;

    public static void main(String[] args) {
        Stack s = new Stack();

        // insertion
        for (int i = 0; i < 10; i++) {
            int x = 32 + (int) (Math.random() * 95);
            System.out.println(x + " --> " + (char) x);
            s.push((char) x);
        }

        // removal and display
        for (int i = 0; i < 10; i++) {
            System.out.println("Item at the top: " + s.peek());

            s.pop();
        }

        s.peek();
    }

    /**
     * Push method of the Stack
     * 
     * @param c
     */
    public void push(char c) {
        if (top == size) {
            System.out.println("Stack is full");
            return;
        } else {
            list[top] = c;
            top++;
        }
    }

    /**
     * Pop method of the Stack
     */
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        } else {
            top--;
        }
    }

    /**
     * Peek method of the Stack
     *  
     * @return top element of the stack
     */
    public char peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return ' ';
        } else {
            return list[top - 1];
        }
    }

    /**
     * IsEmpty method of the Stack
     * 
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

}