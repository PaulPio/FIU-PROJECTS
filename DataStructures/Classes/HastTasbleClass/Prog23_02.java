package HastTasbleClass;

public class Prog23_02{
    public static void main(String[] args){
        new Prog23_02();
    }

    public Prog23_02(){
        HashTable ht = new HashTable(10);
        ht.add("byte");
        ht.add("abstract");
        ht.add("class");
        ht.add("interface");
        ht.add("for");
        ht.add("if");
        ht.add("float");
        ht.add("void");
        ht.add("extends");
        
        
        ht.print();

        System.out.println("Search -for-: " + ht.search("for"));
        ht.remove("for");
        System.out.println("Search -for- after remove method: " + ht.search("for"));

        

    }
}
