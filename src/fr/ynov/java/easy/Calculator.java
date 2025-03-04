package fr.ynov.java.easy;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        System.out.println("Enter an operation (+, -, *, /):");
        Scanner scan = new Scanner(System.in);
        String operation = scan.nextLine();

        switch (operation) {
            case "+":
                System.out.println(number1 + number2);
                break;
            case "-":
                System.out.println(number1 - number2);
                break;
            case "*":
                System.out.println(number1 * number2);
                break;
            case "/":
                System.out.println(number1 / number2);
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}
