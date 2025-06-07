package src.A2.simulator;
import src.A2.animals.*;
class Square {
    private Animal animal;//if animal == null, then square is empty

    public boolean isEmpty() {
        return animal == null;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void removeAnimal() {
        this.animal = null;
    }

    public Animal getAnimal() {
        return animal;
    }

    public char getSymbol() {
        return animal == null ? ' ' : animal.getSymbol();
    }
}
