package src.A2.simulator;
import src.A2.animals.*;
import java.util.*;


/*
* This program simulates interactions among animals on a 2D board
* Board is a n by n square shape field where n is given by user
* There are two classes of animals on the board: Prey and Predator
* The current version has one type of Prey, Mouse, and two types of Predators, Cat and Aligator.
* In each step of the simulation, Prey randomly moves to one of its neighboring squares in one of these directions:
* up, down, left, or right
* Also, Predator moves toward the closest Prey.
* Neither Prey nor Predator can move more than one hop/square in each step of simulation
* If a Prey and Predator happen to be on the same square, Predator eats Prey and Prey will be eliminated.
* If two Predators happen to be on te same square, Predator with higher power-level eats the other.
* If two Preys, or two Predators with the same power-level, happen to be on the same square, the animal with higher
* ID number is moved to a random empty square on the field to resolve collision.
* */
public class AnimalSimulation {
    public static Random random = new Random();//replace Random() with Random(0) to get non-randomized output.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the board size (n): ");
        int n = scanner.nextInt();
        System.out.println("Enter the number of animals per type (k): ");
        int k = scanner.nextInt();

        if (n < 6 || n > 25 || k < 2 || k > 5) {
            System.out.println("Invalid input. n must be 6-25 and k must be 2-5.");
            return;
        }
        Board board = initializeBoard(n, k);
        int time = 0;
        System.out.println("Time t = " + time++ + ": ");
        board.display();

        for (; board.simulateStep() && time <= 50; time++) {
            System.out.println("Time t = " + time + ": ");
            board.display();
        }
        System.out.println("End of simulation ");

        scanner.close();
    }

    private static Board initializeBoard(int n, int k) {
//creates an empty board first
//adds all 3k animals to the board at random positions!
        Board board = new Board(n);
        int id = 0;
        for (int i = 0; i < k; i++) {//Predators...
            while (true) {
                int x = random.nextInt(n);//uniformly distributed random number from 0, 1, ..., n-1
                int y = random.nextInt(n);
                if (board.isEmpty(x, y)) {
                    board.addAnimal(new Cat(id++, x, y));
                    break;
                }
            }

            while (true) {
                int x = random.nextInt(n);
                int y = random.nextInt(n);
                if (board.isEmpty(x, y)) {
                    board.addAnimal(new Alligator(id++, x, y));
                    break;
                }
            }
        }
        for(int i = 0; i < k;i++){//add prey on the board
            while (true) {
                int x = random.nextInt(n);
                int y = random.nextInt(n);
                if (board.isEmpty(x, y)) {
                    board.addAnimal(new Mouse(id++, x, y));
                    break;
                }
            }
        }
        return board;
    }
}
