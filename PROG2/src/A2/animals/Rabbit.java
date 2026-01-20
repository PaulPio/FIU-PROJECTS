package src.A2.animals;

public class Rabbit extends Prey {
    public Rabbit(int id, int x, int y) {
        super(id, x, y);
    }

    @Override
    public char getSymbol() {
        return 'R';
    }

    /**
     * Display the location of the animal
     * @return a string with location of the animal in board
     */
    @Override
    public String toString(){
        return String.format("Rabbit #%d @(%d, %d)", getId(), getX(), getY());
    }
}
