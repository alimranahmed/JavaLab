package com.imranic.leetcode.cyclicsort;

import java.util.ArrayList;
import java.util.List;

// 442. Find All Duplicates in an Array
// https://leetcode.com/problems/find-all-duplicates-in-an-array
// Asked in Amazon & Microsoft
public class DuplicateNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> output = (new DuplicateNumbers()).findDuplicates(nums);
        System.out.println(output.toString());
    }

    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                missingNumbers.add(nums[index]);
            }
        }

        return missingNumbers;
    }

    public void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
