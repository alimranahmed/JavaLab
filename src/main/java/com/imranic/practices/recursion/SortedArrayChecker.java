package com.imranic.practices.recursion;

public class SortedArrayChecker {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 9, 8, 9 };
        System.out.println(isSorted(arr, 0));
    }

    public static boolean isSorted(int[] arr, int startingIndex) {
        if (startingIndex == arr.length -1) {
            return true;
        }

        return arr[startingIndex] <= arr[startingIndex + 1]
                && isSorted(arr, startingIndex + 1);
    }
}
