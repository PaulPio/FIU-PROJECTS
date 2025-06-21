package src.A2.animals;

public class Shark extends Predator {
    public Shark(int id, int x, int y) {
        super(id, x, y, 12);
    }
    @Override
    public char getSymbol() {
        return 'S';
    }
    @Override
    public String toString(){
        return String.format("Shark #%d @(%d, %d)", getId(), getX(), getY());
    }
}
