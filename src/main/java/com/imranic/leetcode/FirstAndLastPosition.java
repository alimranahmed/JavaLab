package com.imranic.leetcode;

import java.util.Arrays;

// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] output = (new FirstAndLastPosition()).searchRange(nums, target);
        System.out.println(Arrays.toString(output));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = search(nums, target, true);
        int end = search(nums, target, false);

        return new int[]{start, end};
    }

    // binary search to return the index of target

    int search(int[] nums, int target, boolean findStartIndex) {

        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]){
                start = mid + 1;
            } else {
                // potential answer found
                ans = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
