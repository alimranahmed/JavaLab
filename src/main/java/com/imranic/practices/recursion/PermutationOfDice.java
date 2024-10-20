package com.imranic.practices.recursion;

import java.util.ArrayList;

public class PermutationOfDice {
    public static void main(String[] args) {
        System.out.println(diceCombination("", 4));
    }

    static ArrayList<String> diceCombination(String processed, int target) {
        if (target == 0) {
            ArrayList<String> combination = new ArrayList<>();
            combination.add(processed);
            return combination;
        }

        ArrayList<String> all = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ArrayList<String> single = diceCombination(processed + i, target - i);
            all.addAll(single);
        }
        return all;
    }
}
