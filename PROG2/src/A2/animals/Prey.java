package src.A2.animals;
import java.util.*;
import src.A2.simulator.*;
public class Prey extends Animal {
    public Prey(int id, int x, int y) {
        super(id, x, y);
    }


    @Override
    public boolean move(Board board) {
        List<int[]> neighbors = board.getNeighboringSquares(x, y);
        if (!neighbors.isEmpty()) {
            int[] newLocation = neighbors.get(AnimalSimulation.random.nextInt(neighbors.size()));
            board.updatePosition(this, newLocation[0], newLocation[1]);
            return true;
        }
        return false;
    }
}
