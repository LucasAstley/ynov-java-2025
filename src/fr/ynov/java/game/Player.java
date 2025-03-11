package fr.ynov.java.game;

public class Player {

    private final String name;
    private int score;

    public Player(final String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
