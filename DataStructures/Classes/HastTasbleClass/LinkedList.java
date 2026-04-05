package HastTasbleClass;

public class LinkedList implements ListInterface {

    public class Node {

        private String info;   
        private Node next;  

        public Node() {
            info = "<empty>";
            next = null;
        }

        public void setInfo(String i) {
            info = i;
        }

        public void setNext(Node l) {
            next = l;
        }

        public String getInfo() {
            return info;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node first;

    public LinkedList() {
        first = new Node();
    }

    public boolean isEmpty() {
        return (first.getNext() == null);
    }

    public void display() {
        Node current = first.getNext();

        while (current != null) {
            System.out.print(current.getInfo() + " ");
            current = current.getNext();
        }

        System.out.println();
    }

    public boolean search(String x) {
        Node current = first.getNext();

        while (current != null) {
            if (current.getInfo().equals(x)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public int length(){
        int counter = 0;
        Node current = first.getNext();

        while (current != null) {
            counter++;
            current = current.getNext();
        }

        return counter;
    }

    public void add(String x) {
        Node p = new Node();

        p.setInfo(x);
        p.setNext(first.getNext());

        first.setNext(p);
    }

    public void remove(String x) {
        Node old = first.getNext(),
                p = first;

        boolean found = false;
        while (old != null && !found) {
            if (old.getInfo().equals(x)) {
                found = true;
            }
            else {
                p = old;
                old = p.getNext();
            }
        }

        if (found) {
            p.setNext(old.getNext());
        }
    }

    public void insert(String x, int loc) {
        if(loc >= length()){
            System.out.println("Incorrct location!");
        }else{
            Node current = first;
            for(int i=0; i<loc; i++){
                current = current.getNext();
            }

            Node p = new Node();
            p.setInfo(x);
            p.setNext(current.getNext());
            current.setNext(p);
        }
    }

    public void removeItemAt(int loc) {
        if(loc >= length()){
            System.out.println("Incorrct location!");
        }else{
            Node current = first;
            for(int i=0; i<loc; i++){
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
    }

    public int count(){
        return countItems(first.getNext());
    }

    private int countItems(Node node){
        if (node == null) return 0;
        else return 1 + countItems(node.getNext());
    }
}