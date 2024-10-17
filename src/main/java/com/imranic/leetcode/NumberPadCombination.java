package com.imranic.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number
// This usage similar approach as we did in practices/recursion/permutation
public class NumberPadCombination {
    public static void main(String[] args) {
        NumberPadCombination npc = new NumberPadCombination();
        List<String> combinations = npc.letterCombinations("23");
        System.out.println(combinations);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }
        return numberPad("", digits);
    }

    private List<String> numberPad(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return List.of(processed);
        }

        List<String> result = new ArrayList<>();
        char digit = unprocessed.charAt(0);
        for (int i = 0; i < getLetters(digit).length(); i++) {
            char ch = getLetters(digit).charAt(i);
            List<String> list = numberPad(processed + ch, unprocessed.substring(1));
            result.addAll(list);
        }
        return result;
    }

    private String getLetters(char digit) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map.get(digit);
    }
}
