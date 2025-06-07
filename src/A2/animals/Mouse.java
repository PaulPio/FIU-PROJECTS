package src.A2.animals;

public class Mouse extends Prey {
    public Mouse(int id, int x, int y) {
        super(id, x, y);
    }

    @Override
    public char getSymbol() {
        return 'M';
    }
    @Override
    public String toString(){
        return String.format("Mouse #%d @(%d, %d)", getId(), getX(), getY());
    }
}
