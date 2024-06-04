package com.imranic.algorithms;

public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 10, 55, 79, 90};
        int target = 55;
        int foundIndex = search(arr, target, 0, arr.length - 1);
        System.out.println(foundIndex);
    }

    static int search(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return search(arr, target, start, mid - 1);
        }
        return search(arr, target, mid + 1, end);
    }
}
