package fr.ynov.java.game;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private boolean gameRunning = true;
    private final Scanner scanner;

    private enum GameChoice {
        ROCK,
        PAPER,
        SCISSORS
    }

    /**
     * Constructs a new game with the given player names
     *
     * @param humanPlayerName    Name of the human player
     * @param computerPlayerName Name of the computer player
     */
    public Game(final String humanPlayerName, final String computerPlayerName) {
        this.humanPlayer = new Player(humanPlayerName);
        this.computerPlayer = new Player(computerPlayerName);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome " + humanPlayer.getName() + " !");
        System.out.println("Let's play Rock, Paper, Scissors !");

        while (gameRunning) {
            playRound();
        }

        end();
    }

    /**
     * Converts abbreviated input to full GameChoice
     *
     * @param choice The user input string
     * @return The corresponding GameChoice
     */
    private GameChoice parsePlayerChoice(String choice) {
        choice = choice.toUpperCase();
        return switch (choice) {
            case "R" -> GameChoice.ROCK;
            case "P" -> GameChoice.PAPER;
            case "S" -> GameChoice.SCISSORS;
            default -> GameChoice.valueOf(choice);
        };
    }

    /**
     * Determines if this choice wins against another choice
     *
     * @param playerChoice The player's choice
     * @param computerChoice The computer's choice
     * @return true if this choice beats the other choice
     */
    private boolean beats(GameChoice playerChoice, GameChoice computerChoice) {
        return (playerChoice == GameChoice.ROCK && computerChoice == GameChoice.PAPER) ||
                (playerChoice == GameChoice.PAPER && computerChoice == GameChoice.SCISSORS) ||
                (playerChoice == GameChoice.SCISSORS && computerChoice == GameChoice.ROCK);
    }

    private void playRound() {
        System.out.println();
        GameChoice humanChoice = askPlayerChoice();
        GameChoice computerChoice = getRandomComputerChoice();
        System.out.println("\nComputer choice : " + computerChoice);

        if (humanChoice == computerChoice) {
            System.out.println("It's a draw !");
        } else if (beats(humanChoice, computerChoice)) {
            System.out.println(humanPlayer.getName() + " wins !");
            humanPlayer.setScore(humanPlayer.getScore() + 1);
        } else {
            System.out.println(computerPlayer.getName() + " wins !");
            computerPlayer.setScore(computerPlayer.getScore() + 1);
        }

        System.out.println();

        if (!askPlayAgain()) {
            gameRunning = false;
        }
    }

    /**
     * Generates a random choice for the computer
     *
     * @return A random GameChoice (gameChoice enum)
     */
    private GameChoice getRandomComputerChoice() {
        GameChoice[] choices = GameChoice.values();
        return choices[(int) (Math.random() * choices.length)];
    }

    /**
     * Prompts the player for their choice
     *
     * @return The player's GameChoice (gameChoice enum)
     */
    private GameChoice askPlayerChoice() {
        System.out.println("Enter your choice " + Arrays.toString(GameChoice.values()) + " (or R, P, S) :");
        String playerChoice = scanner.nextLine();
        try {
            return parsePlayerChoice(playerChoice);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input, please try again");
            return askPlayerChoice();
        }
    }

    /**
     * Asks if the player wants to play another round
     *
     * @return true if the player wants to continue
     * false if the player wants to stop
     */
    private boolean askPlayAgain() {
        System.out.println("Do you want to play again ? (yes/no)");
        String replay = scanner.nextLine().toLowerCase();

        if (replay.equals("yes") || replay.equals("y")) {
            return true;
        } else if (replay.equals("no") || replay.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid input, please try again");
            return askPlayAgain();
        }
    }

    private void end() {
        System.out.println("\nGame over !");

        System.out.println("\nFinal score :");
        System.out.println(humanPlayer.getName() + " : " + humanPlayer.getScore());
        System.out.println(computerPlayer.getName() + " : " + computerPlayer.getScore());

        System.out.println();
        if (humanPlayer.getScore() > computerPlayer.getScore()) {
            System.out.println(humanPlayer.getName() + " wins !");
        } else if (humanPlayer.getScore() < computerPlayer.getScore()) {
            System.out.println(computerPlayer.getName() + " wins !");
        } else {
            System.out.println("It's a draw !");
        }

        scanner.close();
    }
}