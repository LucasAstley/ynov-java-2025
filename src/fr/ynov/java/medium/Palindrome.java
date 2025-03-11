package fr.ynov.java.medium;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        String reverseWord = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseWord += str.charAt(i);
        }
        return str.equals(reverseWord);
    }

    public static void main(String[] args) {
        assert !isPalindrome("bonjour");
        assert isPalindrome("kayak");
        assert isPalindrome("radar");
        assert isPalindrome("été");
        assert isPalindrome("121");
    }
}
