package src.A2.animals;
import src.A2.simulator.*;
public class Predator extends Animal {
    protected int power;

    public Predator(int id, int x, int y, int power) {
        super(id, x, y);
        this.power = power;
    }

    public int getPower() {
        return power;
    }

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
