public class Queue
{

    public Queue()
    {
        size = 100;
        list = new char[size];

        front = 0;
        back = size - 1;

        count = 0;
    }

    public Queue(int s)
    {
        size = s;
        list = new char[size];

        front = 0;
        back = size - 1;

        count = 0;
    }

    public void enqueue(char c)
    {
        back = (back + 1) % size;
        list[back] = c;
        count++;
    }

    public void dequeue()
    {
        front = (front + 1) % size;
        count--;
    }

    public char getFront()
    {
        return list[front];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    private char[] list;
    private int size;
    private int count;
    private int front, back;
}
