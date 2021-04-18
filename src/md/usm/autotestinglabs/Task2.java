package md.usm.autotestinglabs;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a three-digit integer: ");

        String inputString = input.next();

        if (inputString.equals(new StringBuffer(inputString).reverse().toString())) {
            System.out.println(inputString + " is a palindrome");
        } else {
            System.out.println(inputString + " is not a palindrome");
        }
    }
}
