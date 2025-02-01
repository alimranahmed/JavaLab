package com.imranic.leetcode.grind75;

import java.util.HashSet;

// 409. Longest Palindrome
// https://leetcode.com/problems/longest-palindrome
public class LongestPalindrome {
    public static void main(String[] args) {
        int length = (new LongestPalindrome()).longestPalindrome("abccccdd");
        System.out.println(length);;
    }

    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        HashSet<Character> set = new HashSet<>();

        int countOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                countOdd--;
                set.remove(c);
            } else {
                set.add(c);
                countOdd++;
            }
        }

        if (countOdd > 0) {
            return s.length() - countOdd + 1;
        }
        return s.length();
    }
}
