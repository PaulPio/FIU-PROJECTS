package src.A2.animals;

public class Cat extends Predator {
    public Cat(int id, int x, int y) {
        super(id, x, y, 2);
    }

    @Override
    public char getSymbol() {
        return 'C';
    }
    @Override
    public String toString(){
        return String.format("Cat #%d @(%d, %d)", getId(), getX(), getY());
    }
}
