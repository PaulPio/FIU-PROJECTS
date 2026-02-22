/**
 * Implemnet a recursive function that prints an array backwards
 */
public class Program_17_04
{
    public static void main(String[] args)
    {
        //Test
        char[] list = {'H', 'e', 'l', 'l', 'o'};
        
        char[] newList = generateRandomArray(5);
        printBackwards(list, list.length - 1);

        printBackwards1(newList);

        printBackwards2(newList);

    }
    /**
     * Print an array backwards
     * @param list
     * @param index
     */
    public static void printBackwards(char[] list, int index)
    {
        //Base case 
        if (index < 0)
        { 
            System.out.println(); // new line
            return; //Terminates the function
        }
        //Recursive case
        System.out.print(list[index] + " ");
        //Recursive call
        printBackwards(list, index - 1);
    }

    /*
    * Print an array backwards using a helper function 
    * @param list
    */
    public static void printBackwards1(char[] list) {
        //Helper function 
        printBackwards(list, list.length - 1);
    }


    
    /*
    * Print an array backwards using a helper function using the second method
    * @param list
    */
    public static void printBackwards2(char[] list) {
        //Helper function 
        printBackwards2(list,0);
    }

    /**
     * Print an array backwards using a helper function using the second method
     * @param list
     * @param index
     */
    public static void printBackwards2(char[] list, int index) {
        //Base case
        if (index != list.length){
            printBackwards2(list, index + 1);
            System.out.print(list[index] + " ");
        }
    }


    /**
     * function that generates a random array of chars
     * @param size
     * @return
     */
    public static char[] generateRandomArray(int size) {
        char[] array = new char[size]; // create an array of size
        // fill the array with random characters
        for (int i = 0; i < size; i++) {
            // generate a random number between 0 and 25
            array[i] = (char) (Math.random() * 26 + 'a'); // convert the number to a char
            // add the char to the array
        }
        return array; // return the array
    }
}