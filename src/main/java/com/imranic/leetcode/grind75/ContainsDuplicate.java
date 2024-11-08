package com.imranic.leetcode.grind75;

import java.util.HashSet;

// 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate
public class ContainsDuplicate {
    public static void main(String[] args) {
        boolean hasDuplicate = new ContainsDuplicate()
                .containsDuplicate(new int[]{1, 2, 3, 1});
        System.out.println(hasDuplicate);
    }

    /**
     * The idea is, as you are looking for duplicate entries
     * We put each value into a set
     * Checking if the set already contains the value
     * If yes, then duplicate found(true), if not then return false
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> existingList = new HashSet<>();
        for (int n : nums) {
            if (existingList.contains(n)) {
                return true;
            }
            existingList.add(n);
        }
        return false;
    }
}
