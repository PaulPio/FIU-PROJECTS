package src.Q6;

import java.io.*;

public class Test{

    public static void writeFile(String id) {

        PrintWriter pw = null;

        try {

            pw = new PrintWriter(new FileOutputStream("src/Q6/Test.txt"));

            //Note: PrintWriter has these four constructors:

            //1. Simplest one: receives the String filename (e.g. "Test.txt")

            //2. Similar to Scanner's constructor: receives a File object

            // For example, new File("Test.txt")

            //3. Like in this example, receives an object of class

            //FileOutputStream (e.g. new FileOutputStream("Test.txt"))

            //4. Similar to #3, receives an object of FileOutputStream

            //, but allows you to append data to the existing content

            // of the file. For example, new FileOutputStream("Test.txt", true)

            //where true is a flag to ensure the APPEND operation

            //By default, like #3, PrintWriter overwrites the existing content.

            for (int i=0; i<5; i++)

                pw.println("id " + id + ":  i=" + i);

            pw.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e);

        }

    }

    public static void main(String[] args) {

        for(String string: new String[]{"first", "second", "third", "last"})

            writeFile(string);

    }

}
