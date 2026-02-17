import java.util.Random;
public class Prog_19_01 {
    
    public static void main(String[] args) {
        new Prog_19_01();
    }

    public Prog_19_01(){
        int[] a = new int[50000];
        SortingAlgorithms.fillRandom(a);
        SortingAlgorithms.printArray(a);
        SortingAlgorithms.bubblesort(a);
        SortingAlgorithms.printArray(a);
    }

    
}
