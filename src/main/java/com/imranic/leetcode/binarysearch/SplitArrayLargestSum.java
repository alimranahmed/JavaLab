package com.imranic.leetcode.binarysearch;

// 410. Split Array Largest Sum
// https://leetcode.com/problems/split-array-largest-sum
public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        int output = (new SplitArrayLargestSum()).splitArray(nums, k);
        System.out.println(output);
    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }

        while (start < end) {
            // try for the middle as potential ans
            int mid = start + (end - start) / 2;

            // Calculate how many pices you can devide this in with max sum
            int sum = 0;
            int pieces = 1;
            for (int num: nums) {
                if (sum + num > mid) {
                    // you cannot add this in this subarry, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end; // or start as start == end
    }

}
