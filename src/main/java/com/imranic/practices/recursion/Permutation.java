package com.imranic.practices.recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        ArrayList<String> list = permutations("", "abc");
        System.out.println(list);
    }

    // This return the permutation of a given string
    // For example: abc
    // Will return "abc", "acb", "bac", "bca", "cab", "cba"
    // This use recursion approach
    public static ArrayList<String> permutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> permutations = new ArrayList<>();
            permutations.add(processed);
            return permutations;
        }

        char ch = unprocessed.charAt(0);

        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= processed.length(); i++) {
            String firstPart = processed.substring(0, i);
            String secondPart = processed.substring(i);
            ans.addAll(permutations(firstPart + ch + secondPart, unprocessed.substring(1)));
        }
        return ans;
    }
}
