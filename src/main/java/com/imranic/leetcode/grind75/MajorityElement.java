package com.imranic.leetcode.grind75;

import java.util.Arrays;

// 169. Majority Element
// https://leetcode.com/problems/majority-element
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    // The idea is, if the number appears more than half-length of the array
    // Then the middle index will always hold the number
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
