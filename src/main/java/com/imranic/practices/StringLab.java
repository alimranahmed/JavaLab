package com.imranic.practices;

public class StringLab {
    public static void main(String[] args) {
        String a = "Imran";
        String b = "Imran";
        System.out.println(a == b); // true as reference to same object

        String name1 = new String("Imran");
        String name2 = new String("Imran");

        System.out.println(name1 == name2); // false as reference to different object

        System.out.println(name1.equals(name2)); // true as holds same value

        System.out.println(name1.charAt(0)); // Return 0th character of name1

        System.out.println(isPalindrome("Madam"));
        System.out.println(isPalindrome("Imran"));
    }

    static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        str = str.toLowerCase();
        for (int i = 0; i <= str.length() / 2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(str.length() - i - 1);
            if (start != end) {
                return false;
            }
        }

        return true;
    }
}
