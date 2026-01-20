package src.DF9;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for(int i = 0; i < 5;i++)//append to the list
            numbers.addLast(i);
        ListIterator<Integer> it = numbers.listIterator();
        while(it.hasNext()){//iterate through the list
            System.out.print(it.next());//print the next item
            if(it.hasNext())//not the last item
                System.out.print(" -> ");//separator
            else//the last item
                System.out.println();
        }
        while(it.hasPrevious()) {//iterate in reverse order...
            it.previous();
            if(it.hasPrevious()) {
                it.previous();
                it.remove();//remove item
            }
        }
        int count = 1;
        for(int number: numbers){//iterate through the list
            System.out.print(count + ": " + number);
            if(count != numbers.size() - 1)//not the last number
                System.out.print(" -> ");
            count++;
        }
    }
}
