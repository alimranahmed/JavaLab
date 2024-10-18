package com.imranic.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters
public class LongestSubstring {
    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(longestSubstring.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(longestSubstring.lengthOfLongestSubstring("abba")); // 2
        System.out.println(longestSubstring.lengthOfLongestSubstring("aab")); // 2
        System.out.println(longestSubstring.lengthOfLongestSubstring("cdd")); // 2
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(end < s.length()){
            char x = s.charAt(end);
            if(map.containsKey(x) && map.get(x) >= start) {
                start = map.get(x) + 1;
                map.put(x, end);
                end++;
            } else {
                map.put(x, end);
                end++;
                max = Math.max(max, (end-start));
            }
        }
        return max;
    }
}
