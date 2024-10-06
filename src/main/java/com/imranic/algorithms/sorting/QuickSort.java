package com.imranic.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 2, 5, 3, 4, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // Select a pivot(p)
    // On 1st Pass: all elements < p will be on the right hand side
    //      and all elements > p will be on the left hand side
    // Then repeat the same procedure for left and right side of the pivot
    // Which means after every pass we are putting the pivot element in the right place
    static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid];

        if (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }
        }

        if (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        quickSort(nums, low, end);
        quickSort(nums, start, high);
    }
}
