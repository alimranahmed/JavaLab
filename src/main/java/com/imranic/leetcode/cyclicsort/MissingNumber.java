package com.imranic.leetcode.cyclicsort;

import java.util.ArrayList;
import java.util.List;

// 268. Missing Number
// https://leetcode.com/problems/missing-number
// Cyclic Sort
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int output = (new MissingNumber()).missingNumber(nums);
        System.out.println(output);
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(nums, i, nums[i]);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index) {
                return index;
            }
        }

        return nums.length;
    }

    public void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
