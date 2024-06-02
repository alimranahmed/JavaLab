package com.imranic.leetcode.cyclicsort;

// 287. Find the Duplicate Number
// https://leetcode.com/problems/find-the-duplicate-number
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        int output = (new DuplicateNumber()).findDuplicate(nums);
        System.out.println(output);
    }

    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[correctIndex] != nums[i]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return nums[j];
            }
        }

        return -1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
