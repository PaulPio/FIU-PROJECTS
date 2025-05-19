package util;

public class Students {
    private String firstName;
    private String lastName;
    private int pantherID;
    private int score;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPantherID() {
        return pantherID;
    }

    public void setPantherID(int pantherID) {
        this.pantherID = pantherID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Students(String firstName, String lastName, int pantherID, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pantherID = pantherID;
        this.score = score;

    }
}
