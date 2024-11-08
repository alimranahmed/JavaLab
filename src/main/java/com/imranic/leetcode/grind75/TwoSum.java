package com.imranic.leetcode.grind75;

import java.util.Arrays;
import java.util.HashMap;

// 1. Two Sum
// https://leetcode.com/problems/two-sum
public class TwoSum {
    public static void main(String[] args) {
        int[] indexes = new TwoSum()
                .twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(indexes));
    }

    /**
     * The idea of this solution is:
     * We have a target to make with the same of two numbers
     * Therefore, target - number1 = number2
     * So, we made a hash map: target - number1 => index_of_number1
     * While traversing through the array,
     * we check if the number exists as a key of hash map
     * If yes, then the current key and the hash map value is the result
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(target - n, i);
        }
        return new int[]{-1, -1};
    }
}
