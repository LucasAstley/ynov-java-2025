package fr.ynov.java.easy;

import java.util.Scanner;

public class ScanMe {

    public static void main(String[] args) {
        System.out.println("Enter you name:");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        System.out.println("Enter your age:");
        int age = scan.nextInt();

        System.out.println("Hello " + name + ", you are " + age + " years old.");
    }
}
