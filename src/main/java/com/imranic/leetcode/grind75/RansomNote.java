package com.imranic.leetcode.grind75;

// 383. Ransom Note
// https://leetcode.com/problems/ransom-note
public class RansomNote {
    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("a", "b"));
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            freq[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            freq[ransomNote.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count < 0) {
                return false;
            }
        }

        return true;
    }
}
