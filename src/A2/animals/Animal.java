package src.A2.animals;
import src.A2.simulator.*;
public class Animal {
    protected int id;//unique unsigned integer
    protected int x, y;//location of animal on the board/grid:
    // x is the row index, y is the column index
    //x increases as we go down
    //y increases as we go to the right
    //origin (0,0) is on the top-left corner of board

    public Animal(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public char getSymbol(){return 'X';}
    public boolean move(Board board){
        /*cannot generalize the move as each animal moves differently!*/
        return true;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
