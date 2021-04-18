package md.usm.autotestinglabs;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter celsius: ");

        System.out.println("Fahrenheit: " + (9.0 / 5) * input.nextDouble() + 32);
    }
}
