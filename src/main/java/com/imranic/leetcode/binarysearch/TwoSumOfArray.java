package com.imranic.leetcode.binarysearch;

import java.util.Arrays;

// 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
public class TwoSumOfArray {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString((new TwoSumOfArray()).twoSum(nums, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length - 1;
        while(s < e) {
            if (numbers[s] + numbers[e] == target) {
                return new int[]{s + 1, e + 1};
            } else if (target > numbers[s] + numbers[e]) {
                s++;
            } else {
                e--;
            }
        }
        return new int[]{s + 1, e + 1};
    }
}
