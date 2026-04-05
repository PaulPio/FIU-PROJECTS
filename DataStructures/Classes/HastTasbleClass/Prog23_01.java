package HastTasbleClass;

/**
 * Tests hash function for strings.
 *
 * @author Prof. Antonio Hernandez
 */
public class Prog23_01
{

    public static void main(String[] args)
    {
        new Prog23_01();
    }

    /**
     * Tests hash function.
     */
    public Prog23_01()
    {
        //TO IMPLEMENT
    }

    /**
     * Implements a hash function for strings.
     *
     * @param key given string
     * @param tableSize size of hash table
     * @return hash value for given string
     */
    public int hash(String key, int tableSize)
    {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++)
        {
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0)
            hashVal += tableSize;

        return hashVal;
    }

}
