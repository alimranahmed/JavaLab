package com.imranic.leetcode.grind75;

// 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println((new ValidAnagram()).isAnagram("anagram", "nagaram"));
        System.out.println((new ValidAnagram()).isAnagram("rat", "car"));
    }

    /**
     * One string(t) anagram of another string(t)
     * if t has all the characters with same frequency as s
     * Simple approach(O(n)) is having
     * Size of both string is same
     * an array with 26 size
     * For each char: increase frequency counter for one char in s
     * and decrease the frequency counter for one char in t
     * If there is any value in the array that is greater than 0, then it's not an anagram
     * Alternative approach(O(nlogn)): sort both string's char arrays(s.toCharArray()) and then compare two arrays(Arrays.equals(a1, a2))
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}
