package fr.ynov.java.game;

import java.util.Scanner;


public class RockPaperScissors {

    /**
     * Main class for the Rock, Paper, Scissors game
     */
    public static void main(String[] args) {

        Interface.createWindow("Rock Paper Scissors");

        System.out.println("Enter you name :");
        Scanner scan = new Scanner(System.in);
        String playerName = scan.nextLine();
        Game game = new Game(playerName, "Computer");
        game.start();
    }
}
