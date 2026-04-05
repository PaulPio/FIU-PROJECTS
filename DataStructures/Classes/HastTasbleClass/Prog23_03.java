package HastTasbleClass;

public class Prog23_03 {
    public static void main(String[] args) {
        new Prog23_03();
    }

    public Prog23_03() {

    }

    public class HashTable{
        String [] table;
        
        byte[] locationStatus; //-1:removed; 0:empty; 1:occupied
        int tableSize;
        int length; //number of elements currently stored
        //in the hash table
        public HashTable() {
        tableSize = 5;
        table = new String[tableSize];
        locationStatus = new byte[tableSize];
        for (int i=0; i<tableSize; i++) {
            table[i] = "";
            locationStatus[i] = 0;
        }
        length = 0;
        }
    }
    
}
