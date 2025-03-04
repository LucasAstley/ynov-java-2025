package fr.ynov.java.medium;

public class Square {

    public static void main(String[] args) {
        // From the arguments
        int number = Integer.parseInt(args[0]);
        System.out.println(square(number));

        // From the standard input
        //System.out.println(square(3));
    }

    public static int square(int number) {
        return number * number;
    }
}
