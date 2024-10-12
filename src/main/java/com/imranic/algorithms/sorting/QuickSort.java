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
        if (low < high) {
            int partitionIndex = partition(nums, low, high);

            quickSort(nums, low, partitionIndex-1);
            quickSort(nums, partitionIndex+1, high);
        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = (low-1);
        for (int j=low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;

        return i+1;
    }

}
