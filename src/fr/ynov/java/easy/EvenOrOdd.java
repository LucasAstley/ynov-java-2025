package fr.ynov.java.easy;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + " is even!");
        } else {
            System.out.println(number + " is odd!");
        }
    }
}
