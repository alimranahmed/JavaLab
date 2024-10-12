package com.imranic.algorithms.sorting;

import java.util.Arrays;

public class QuickSort1 {
    public static void main(String[] args) {
        int[] nums = {8, 9, 2, 7, 10, 4, 6};
        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    // Select a pivot(p)
    // On 1st Pass: all elements < p will be on the right hand side
    //      and all elements > p will be on the left hand side
    // Then repeat the same procedure for left and right side of the pivot
    // Which means after every pass we are putting the pivot element in the right place
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partitionIndex = partition(nums, left, right);
        quickSort(nums, left, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, right);
    }

    public static int partition(int[] nums, int low, int high) {
        int pivotIndex = low + (high - low) / 2;
        int pivot = nums[pivotIndex];

        while (low < high) {
            while(nums[low] < pivot) {
                low++;
            }
            while (nums[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
