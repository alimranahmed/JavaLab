package com.imranic.leetcode.cyclicsort;

import java.util.Arrays;

// 645. Set Mismatch
// https://leetcode.com/problems/set-mismatch
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] output = (new SetMismatch()).findErrorNums(nums);
        System.out.println(Arrays.toString(output));
    }

    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j+1) {
                return new int[]{nums[j], j+1};
            }
        }
        return new int[]{-1, -1};
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
