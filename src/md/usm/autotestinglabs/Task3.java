package md.usm.autotestinglabs;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter string: ");

        int countVowels = 0;
        int countConsonants = 0;
        char[] charArr = input.nextLine().toLowerCase().toCharArray();

        for (char c : charArr) {
            if (c == ' ') {
                continue;
            }

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                countVowels++;
            } else {
                countConsonants++;
            }
        }

        System.out.println("The number of vowels: " + countVowels + "\nThe number of consonants: " + countConsonants);
    }
}
