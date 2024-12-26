package com.imranic.practices;

import java.util.Locale;
import java.util.Scanner;

public class ProgrammingContest {
    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();
        System.out.println(value);
        String line1 = scan.nextLine();
        System.out.print("Say something: ");
        String line2 = scan.nextLine();
        System.out.println(line1);
        System.out.println(line2);

        System.out.printf(Locale.US, "%.2f", 539.5095);

    }
}
