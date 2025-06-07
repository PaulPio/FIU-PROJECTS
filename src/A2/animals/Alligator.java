package src.A2.animals;

public class Alligator extends Predator {
    public Alligator(int id, int x, int y) {
        super(id, x, y, 9);
    }

    @Override
    public char getSymbol() {
        return 'A';
    }
    @Override
    public String toString(){
        return String.format("Aligator #%d @(%d, %d)", getId(), getX(), getY());
    }
}
