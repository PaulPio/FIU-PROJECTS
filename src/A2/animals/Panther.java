package src.A2.animals;

/**
 * Class code for the Panther Predator
 */
public class Panther extends Predator {
    public Panther(int id, int x, int y) {
        super(id, x, y, 15);
    }

    @Override
    public char getSymbol() {
        return 'P';
    }
    @Override
    public String toString(){
        return String.format("Panther #%d @(%d, %d)", getId(), getX(), getY());
    }
}
