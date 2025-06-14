package src.DF4.Q3;

public interface Comparable<T>{
    public int compareTo(T other);/*returns zero if this==other,
     **returns a negative int if this < other,
     **and returns a positive int otherwise*/
}