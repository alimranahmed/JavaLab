package com.imranic.leetcode.cyclicsort;

// 41. First Missing Positive
// https://leetcode.com/problems/first-missing-positive
// Asked in Amazon
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {1};
        int output = (new FirstMissingPositive().firstMissingPositive(nums));
        System.out.println(output);
    }

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
