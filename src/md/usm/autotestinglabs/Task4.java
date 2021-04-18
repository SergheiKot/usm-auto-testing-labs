package md.usm.autotestinglabs;


import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number: ");

        int number = input.nextInt();

        System.out.println("Reverse number: " + reverse(number));

        if (isPalindrome(number)) {
            System.out.println(number + " is palindrome");
        } else {
            System.out.println(number + " is not palindrome");
        }
    }

    public static int reverse(int number) {
        int result = 0;

        while (number != 0) {
            result = (result * 10) + (number % 10);
            number = number / 10;
        }
        return result;
    }

    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }
}
