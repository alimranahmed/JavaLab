package com.imranic.practices.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        //ArrayList<String> subs = produceSubSequence("", "abc");
        //System.out.println(subs);

        ArrayList<List<Integer>> subSets = produceSubSets(new int[]{1, 2, 3});
        for (List<Integer> subSet : subSets) {
            System.out.println(subSet);
        }
    }

    // Will print all possible sub-sequence of originalStr
    // abc => a, b, c, ab, ac, bc, abc
    // We are using recursion here
    private static ArrayList<String> produceSubSequence(String sequence, String originalStr) {
        if (originalStr.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(sequence);
            return list;
        }

        char firstChar = originalStr.charAt(0);
        ArrayList<String> left = produceSubSequence(sequence + firstChar, originalStr.substring(1));
        ArrayList<String> right = produceSubSequence(sequence, originalStr.substring(1));
        left.addAll(right);
        return left;
    }

    // Previous method produceSubSequence() does the same thing with recursion
    // This one is an implementation of producing sub-sequence/sub-set using iteration
    // Let's say we have numbers = [1, 2, 3]
    // It should return: [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]
    private static ArrayList<List<Integer>> produceSubSets(int[] numbers) {
        ArrayList<List<Integer>> subSets = new ArrayList<>();
        subSets.add(new ArrayList<>());

        for (int number : numbers) {
            int size = subSets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> internal = new ArrayList<>(subSets.get(i));
                internal.add(number);
                subSets.add(internal);
            }
        }

        return subSets;
    }
}
