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

    /**
     * Adds an item to the back of the queue.
     * @param c The item to add to the back of the queue.
     */
    public void enqueue(char c)
    {
        if (isFull())
        {
            System.out.println("Queue is full");
            return;
        }
        else{
            back = (back + 1) % size;
            list[back] = c;
            count++;
        }
    }

    /**
     * Removes the item at the front of the queue.
     */
    public void dequeue()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return;
        }
        else{
            front = (front + 1) % size;
            count--;
        }
    }

    /**
     * Returns the item at the front of the queue.
     * @return The item at the front of the queue.
     */
    public char getFront()
    {
        //Check if the queue in empty
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return '\0';
        }
        
        return list[front];
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public boolean isFull()
    {
        return count == size;
    }

    /**
     * Returns the number of items in the queue.
     * @return The number of items in the queue.
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Displays the items on the queue.
     */
    public void display()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty");
            return;
        }
        for (int i = 0; i < count; i++)
        {
            System.out.println(list[(front + i) % size]); // (front + i) % size is used to get the index
            //  of the item at the front of the queue in a circular array 
            //  front is the index of the item at the front of the queue
            //  i is the index of the item at the front of the queue
            //  size is the size of the queue
        }
    }


    /**
     * Clear the current queue.
     */
    public void clear()
    {
        front = 0;
        back = size - 1;
        count = 0;
    }

    private char[] list;
    private int size;
    private int count;
    private int front, back;
}
