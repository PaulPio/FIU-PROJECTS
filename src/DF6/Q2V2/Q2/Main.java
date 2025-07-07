package src.DF6.Q2V2.Q2;
import java.util.*;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args){
        ArrayList<DateTime> list = new ArrayList<>();
        while(keyboard.hasNextLine()){
            System.out.println("Enter the next date/time. Press Ctrl+D to end the sequence");
            String input = keyboard.nextLine();
            String[] tokens= input.split(" ");
            if(tokens.length != 4 || !tokens.equals("@") || !tokens[3].equalsIgnoreCase("am") && !tokens[3].equalsIgnoreCase("pm") ) {
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"");
                continue;
            }
            String[] dateTokens = tokens[0].split("/");
            String[] timeTokens = tokens[0].split(":");
            if(dateTokens.length != 3 || timeTokens.length != 3) {
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"");
                continue;
            }
            try{
                int month = Integer.parseInt(dateTokens),
                        day = Integer.parseInt(dateTokens),
                        year = Integer.parseInt(dateTokens),
                        hour = Integer.parseInt(timeTokens),
                        minute = Integer.parseInt(timeTokens),
                        second = Integer.parseInt(timeTokens);
                DateTime dateTime = new DateTime(new Date(day, month, year),hour,
                        minute, second, tokens.equalsIgnoreCase("am"));
                if(!DateTime.isValidDateTime(dateTime))

                    throw

                            new DateTimeInvalidException(dateTime);
                list.add(dateTime);
            }catch(
                    NumberFormatException

                            exp){
                System.out.println("Invalid format. Try again with this format: \"MM/DD/YYYY @ hh:mm:ss am/pm\"!");
            }
            catch
            (DateTimeInvalidException exp){
                System.out.println(exp.getMessage() + "Try again!");
            }
        }
        Collections.sort(list);
        for(DateTime dateTime: list)
            System.out.println(dateTime);
    }
}
