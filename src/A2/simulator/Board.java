package src.A2.simulator;
import src.A2.animals.*;
import java.util.*;

public class Board {
    private int size;
    private Square[][] grid;
    private List<Animal> animals;
    private List<Animal> eaten;

    public Board(int size) {
        this.size = size;
        grid = new Square[size][size];
        animals = new ArrayList<>();
        eaten = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Square();
            }
        }
    }
    public boolean isEmpty(int x, int y){
        return grid[x][y].isEmpty();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        grid[animal.getX()][animal.getY()].setAnimal(animal);
    }

    public void updatePosition(Animal animal, int newX, int newY) {
        grid[animal.getX()][animal.getY()].removeAnimal();
        Animal current = grid[newX][newY].getAnimal();
        if(current == null){//no collision as the new square is empty!
            grid[newX][newY].setAnimal(animal);
            animal.setPosition(newX, newY);
            return;
        }
        //collision rules!
        if(current instanceof Prey && animal instanceof Prey){//two preys
            if(current.getId() > animal.getId()) {
                moveToRandomPosition(current);
                grid[newX][newY].setAnimal(animal);
                animal.setPosition(newX, newY);
            }
            else {
                moveToRandomPosition(animal);
            }
        }else if (current instanceof Predator && animal instanceof Predator){//two predators
            if(((Predator) current).getPower() > ((Predator) animal).getPower()){
                System.out.printf("Note: %s ate %s.\n", current, animal);
                eaten.add(animal);
                //current resident stays and eats animal...
            }
            else if(((Predator) current).getPower() < ((Predator) animal).getPower()) {
                System.out.printf("Note: %s ate %s.\n", animal, current);
                eaten.add(current);
                grid[newX][newY].setAnimal(animal);
                animal.setPosition(newX, newY);
            }
            else if(current.getId() > animal.getId()) {
                moveToRandomPosition(current);
                grid[newX][newY].setAnimal(animal);
                animal.setPosition(newX, newY);
            }
            else {
                moveToRandomPosition(animal);
            }
        }else if(current instanceof Predator) {
            System.out.printf("Note: %s ate %s.\n", current, animal);
            eaten.add(animal);
        }else {
            System.out.printf("Note: %s ate %s.\n", animal, current);
            eaten.add(current);
            grid[newX][newY].setAnimal(animal);
            animal.setPosition(newX, newY);
        }
    }

    private void moveToRandomPosition(Animal animal) {
        while(true){
            int x = AnimalSimulation.random.nextInt(size), y = AnimalSimulation.random.nextInt(size);
            if(isEmpty(x,y)){
                grid[x][y].setAnimal(animal);
                animal.setPosition(x, y);
                System.out.printf("Note: %s has jumped to (%d, %d).\n", animal, x, y);
                break;
            }
        }
    }

    public Prey findClosestPrey(int x, int y) {
        Prey closestPrey = null;
        int closestDistance = Integer.MAX_VALUE;
        for (Animal animal : animals) {
            if (animal instanceof Prey) {
                int distance = Math.abs(animal.getX() - x) + Math.abs(animal.getY() - y);
                if (distance < closestDistance) {
                    closestDistance = distance;
                    closestPrey = (Prey) animal;
                }
            }
        }
        return closestPrey;
    }

    public List<int[]> getNeighboringSquares(int x, int y) {//e.g. x,y = 0,0 OR x,y = 1,2
        List<int[]> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (newX >= 0 && newX < size && newY >= 0 && newY < size ) {
                neighbors.add(new int[]{newX, newY});
            }
        }

        return neighbors;//[(0,1), (1,0)] OR [(1,1), (1,3), (0,2), (2,2)]
    }

    public void display() {
        System.out.println("---------------------------------------");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j].getSymbol() + "|\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("---------------------------------------");
    }

    public boolean simulateStep() {
        for (Animal animal : animals) {
            if(!eaten.contains(animal))
                if(!animal.move(this))
                    return false;
        }
        for(Animal animal: eaten)
            animals.remove(animal);
        eaten.clear();
        return true;
    }
}
