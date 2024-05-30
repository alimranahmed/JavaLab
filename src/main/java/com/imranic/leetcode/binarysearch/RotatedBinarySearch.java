package com.imranic.leetcode.binarysearch;

// Rotated Binary Search(RBS)
// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array
public class RotatedBinarySearch {
    public static void main(String[] args) {
        //int[] nums = {4,5,6,7,0,1,2};
        int[] nums = {3, 1};
        //int[] nums = {1};
        int target = 4;
        int output = (new RotatedBinarySearch()).search(nums, target);
        System.out.println(output);
    }

    public int search(int[] nums, int target) {
        // Find pivot
        int pivotIndex = findPivot(nums);
        System.out.println(pivotIndex);

        if (pivotIndex == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivotIndex == 0 ? 0 : pivotIndex - 1);
        }

        return binarySearch(nums, target, pivotIndex + 1, nums.length -1);
    }

    public int binarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target < arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // In a rotated sorted array, pivot is the largest number
    // This will not work for duplicate values
    public int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // NOTE: What if these elements at start and end where the pivot?
                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            } else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
