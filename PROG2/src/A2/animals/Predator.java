package src.A2.animals;
import src.A2.simulator.*;
public class Predator extends Animal {
    protected int power;

    /**
     * Constructor of the Predator class
     * @param id Object id
     * @param x Position in x
     * @param y Position in y
     * @param power Power that the Predator has
     */
    public Predator(int id, int x, int y, int power) {
        super(id, x, y);
        this.power = power;
    }

    /**
     * Return the power of the predator
     * @return int with the power of the predator
     */
    public int getPower() {
        return power;
    }

    /**
     * Method that moves the predator animal
     * @param board board on which the object is display
     * @return true if the object moves, false if it doesn't
     */
    @Override
    public boolean move(Board board) {
        Prey closestPrey = board.findClosestPrey(x, y);
        if (closestPrey != null) {
            int dx = closestPrey.getX() - x;
            int dy = closestPrey.getY() - y;
            int newX = x;
            int newY = y;
            if(dx > 0)
                newX++;
            else if(dx < 0)
                newX--;
            else if(dy > 0)
                newY++;
            else if(dy < 0)
                newY--;
            board.updatePosition(this, newX, newY);
            return true;
        }
        return false;
    }
}
