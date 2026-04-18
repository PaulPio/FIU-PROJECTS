
/**
 * Implements the symbol table.
 *
 * @author Paul Piotrowski, 6568148, 1261 - COP3530 - & Data Structures - Sections U01 & U02 
 */
public class HashTable
{
    private final LinkedList[] table;    //hash table
    private final int tableSize;         //hash table size
    private final int hashConstant = 31; //hash constant used in hash function

    /**
     * Parameterized constructor.Sets this hash table as an empty one. Size of
     * the table is set to given size.
     *
     * @param size size of array defined by user
     */
    public HashTable(int size)
    {
        this.tableSize = size; // setting the size of the table
        this.table = new LinkedList[size]; // setting a new linked list array with the requested size
        // seting thevalues inside of the array to linked list objects
        for (int i = 0; i < tableSize; i++) {
            table[i] = new LinkedList();
        }
    }

    /**
     * Adds a string to this hash table.
     *
     * @param str given string
     */
    public void add(String str)
    {
        int value = hash(str); // getting the hash value of the str
        table[value].add(str); // adding the str as value to the linked list
    }

    /**
     * Determines the hash value of a given string of characters.
     *
     * @param key string
     * @return hash value of key
     */
    private int hash(String key)
    {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
        {
            hashVal = hashConstant * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }

    /**
     * Removes from this hash table the given string, if found.
     *
     * @param str given string
     */
    public void remove(String str)
    { 
        int value = hash(str); // getting the hash value of the str
        table[value].remove(str); // removing the str as value to the linked list
    }

    /**
     * Determines if given string is in this hash table.
     *
     * @param str given string
     * @return true if search is successful, false otherwise
     */
    public boolean search(String str)
    {
        int value = hash(str); // // getting the hash value of the str
        // searching the str value in the linked list on the hash table and storing it in a boolean variable
        boolean found = table[value].search(str); 
        return found; //return true if found and false if not
    }

    /**
     * Constructs a String description of this hash table.
     *
     * @return String containing the hash table elements.
     */
    public String toString()
    {
        String str = "";

        for (int i = 0; i < table.length; i++)
        {
            str = String.format(str + "%2d: ", i);

            str += table[i] + "\n";
        }

        return str;
    }
}
