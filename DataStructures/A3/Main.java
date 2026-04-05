
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ASSIGNMENT 3
 * Tester class.
 *
 * @author Prof. A. Hernandez
 */
public class Main
{

    public Main()
    {
        System.out.println("Test starts");

        Dictionary db = new Dictionary("student database.csv"); //student database

        File file = new File("assignment 3 test set.txt");

        String[] tokens = null;
        int ID;
        char grade;
        Student stu;
        
        try
        {
            Scanner in = new Scanner(file);

            String operation = "", param = "";
            int entryNumber = 0;
            while (in.hasNextLine())
            {
                entryNumber++;
                operation = in.next(); //reads command (first word) from file line
                if (operation.equals("IS_EMPTY")
                        || operation.equals("NUMBER_OF_STUDENTS"))
                    System.out.print("\n" + operation + ": ");
                else
                {
                    param = in.nextLine().trim(); //reads rest of file line (parameters)
                    System.out.println("\n" + operation + " " + param);

                    tokens = param.split(" "); //splits rest of line into its components
                }

                switch (operation)
                {
                    case "ADD":
                        //parses the strings
                        String firstName = tokens[0];
                        String lastName = tokens[1];
                        ID = Integer.parseInt(tokens[2]);
                        grade = tokens[3].charAt(0);

                        //defines student and adds it to the database
                        stu = new Student(firstName, lastName, ID, grade);
                        db.add(stu);
                        System.out.println(" Student " + ID + " added");
                        break;

                    case "CHANGE_GRADE":
                        ID = Integer.parseInt(tokens[0]);
                        grade = tokens[1].charAt(0);
                        
                        if (db.changeGrade(ID, grade))
                            System.out.println(" Grade changed completed");
                        else
                            System.out.println(" ID not found");
                        break;

                    case "COUNT_GRADE":
                        grade = tokens[0].charAt(0);
                        System.out.println(" There are " + 
                             db.countGrade(grade) + " " + grade + "'s");
                        break;

                    case "IS_EMPTY":
                        System.out.println(db.isEmpty());
                        break;

                    case "NUMBER_OF_STUDENTS":
                        System.out.println(db.getNumberOfStudents());
                        break;

                    case "PRINT":
                        System.out.println(db);
                        break;

                    case "RETRIEVE":
                        ID = Integer.parseInt(tokens[0]);
                        stu = db.retrieve(ID);
                        
                        if (stu != null)
                            System.out.println(" " + stu);
                        else System.out.println(" ID does not exist");
                        break;

                    default:
                        System.out.println("Operation \"" + operation + 
                                           "\" unknown at line " + entryNumber);
                        System.exit(1);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!");
            System.exit(1);
        }

        System.out.println("Test ends");
    }

    public static void main(String[] args)
    {
        new Main();
    }
}

