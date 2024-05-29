package com.imranic.leetcode.binarysearch;

// Both of the problem is same
// 852. Peak Index in a Mountain Array
// https://leetcode.com/problems/peak-index-in-a-mountain-array
// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element
public class PeakOfMountainArray {
    public static void main(String[] args) {
        int[] arr = {0,10,5,2};
        int output = (new PeakOfMountainArray()).peakIndexInMountainArray(arr);
        System.out.println(output);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            }
        }
        return start; // or return as both are equal
    }
}
