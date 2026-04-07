
import java.util.Arrays;

/**
 * Implements a graph represented with an adjacency matrix.
 * 
 * @author Antonio Hernandez
 */
public class Graph implements GraphInterface
{
    private int verticesNumber; //number of graph vertices
    private int[][] matrix; //adjacency matrix
    
    /**
     * Constructs a graph with 5 vertices and zero edges.
     */
    public Graph()
    {
        verticesNumber = 5;
        matrix = new int[verticesNumber][verticesNumber];
    }
    
    /**
     * Constructs a graph with v vertices and zero edges.
     */
    public Graph(int v)
    {
        verticesNumber = v;
        matrix = new int[verticesNumber][verticesNumber];
    }
    
    /**
     * Adds edge (v, w) to graph.
     * 
     * @param v
     * @param w 
     */
    public void addEdge(int v, int w)
    {
        matrix[v][w] = 1;
        matrix[w][v] = 1;
    }
    
    /**
     * Removes edge (v, w) from graph.
     * 
     * @param v
     * @param w 
     */
    public void removeEdge(int v, int w)
    {
        matrix[v][w] = 0;
        matrix[w][v] = 0;        
    }
    
    /**
     * Finds vertices adjacent to given vertex.
     * 
     * @param v given vertex
     * @return list of adjacent vertices stored in an array
     */
    public int[] findAdjacencyVertices(int v)
    {
        int[] vert = new int[verticesNumber];
        int total = 0;
        
        for (int i=0; i<verticesNumber; i++)
        {
            if (matrix[v][i] == 1)
            {
                vert[total] = i;
                total++;
            }
        }
        
        return Arrays.copyOf(vert, total);        
    }
    
    /**
     * Computes a string description of the adjacency matrix of this graph.
     * 
     * @return string description
     */
    public String toString()
    {
        String s = "";
        
        for (int i=0; i<verticesNumber; i++)
        {
            for (int j=0; j<verticesNumber; j++)
            {
                s += matrix[i][j] + " ";
            }
            s += "\n";
        }
        
        return s;
    }
}