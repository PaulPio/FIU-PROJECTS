/**
 * The class ArrayBag implements a multiset of strings with an array.
 *
 * @author Paul Piotrowski, 6568148, and COP3530 U01 U02 1261
 */
public class ArrayBag
{
    private String[] bag;      //array that holds the bag data
    private int size; // size of the array
    private int length; //number of elements (in other words, n, the size
                        //of the input)

    /**
     * Default constructor. Sets this object as an empty array bag. The size of
     * the array will be 1. The method takes O(1) time.
     */
    public ArrayBag()
    {
        size = 1;
        bag = new String[size];
        length = 0;
    }

    /**
     * Adds new element to the back end of the bag. If the array is full it will
     * be expanded by doubling its size. The method takes O(1) time if the array
     * is not full, O(n) otherwise.
     *
     * @param s new element to be added to the ArrayBag.
     */
    public void add(String s)
    {
        //check if array is full
        if (length == size)
        {
          //create new array with double the size
          String[] newBag = new String[size * 2];
          //copy elements from old array to new array
          for (int i = 0; i < length; i++)
          {
            newBag[i] = bag[i]; //copy element
          }
          bag = newBag; //set bag to new array
          size *= 2; //double the size
        }
        bag[length] = s; //add new element
        length++; //increment length
    }

    /**
     * Determines the number of occurrences in the bag of a given element. The
     * method takes O(n) time.
     *
     * @param s given element
     * @return number of times the given element occurs in the ArrayBag.
     */
    public int count(String s)
    {
        int count = 0; //initialize count
        for (int i = 0; i<length; i++) //iterate through the array
        {
            if (bag[i].equals(s)) //check if element is equal to s
            {
                count++; //increment count
            }
        }
        return count; //return count
    }

    /**
     * Returns number of elements in the bag. The method takes O(1) time.
     *
     * @return number of elements
     */
    public int getNumberOfItems()
    {
        return length; //return length
    }

    /**
     * Determines if this bag is empty. The method takes O(1) time.
     *
     * @return true if ArrayBag contains no elements, false otherwise.
     */
    public boolean isEmpty()
    {
        if (length == 0){
            return true; //return true if bag is empty
        }
        else{
            return false; //return false if bag is not empty
        }
    }

    /**
     * Removes one occurrence of a given element. The method should remove from
     * the bag the first occurrence of the element, if it were present more than
     * once. The order of the remaining elements should be the same they had
     * before removal.  It takes O(n) time.
     *
     * @param s element to be removed.
     */
    public void remove(String s)
    {
        for (int i = 0; i<length; i++) //iterate through the array
        {
            if (bag[i].equals(s)) //check if element is equal to s
            {
                for(int j = i; j<length-1; j++) //Move everything after i one step to the left
                {
                    bag[j] = bag[j+1]; //remove element
                }

                bag[length-1] = null; //Clear the last item reference
                length--; //decrement length
                return; //exit loop, we only want to remove one item
                
            }

        }
    }

    /**
     * Removes all occurrences of a given element s. The order of the remaining
     * elements should be the same they had before removal. It takes O(kn) time,
     * where k is the number of occurrences of s.
     *
     * @param s element to be removed.
     */
    public void removeAll(String s)
    {
        //keep removing the element until it is no longer in the bag
        while(count(s)>0){
            remove(s); //remove one occurrence of the element
        }
    }

    /**
     * Builds a String description of this bag.
     *
     * @return String containing the bag elements.
     */
    public String toString()
    {
        String str = "";

        for (int i = 0; i < length - 1; i++)
        {
            str += bag[i] + ", ";
        }

        if (length != 0)
            return "Bag: {" + str + bag[length-1] + "}";
        else
            return "Bag: {}";
    }
}
