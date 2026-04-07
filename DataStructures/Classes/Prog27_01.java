import java.util.Arrays;

public class Prog27_01 {
    public static void main(String[] args) {
        Prog27_01();
    }
    public static void Prog27_01(){
        Graph g = new Graph();
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(3,4); 
        int [] a = g.findAdjacencyVertices(7); 

        System.out.println(Arrays.toString(a));
    }
}
