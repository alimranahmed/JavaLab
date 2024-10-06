package com.imranic.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8, 3, 4, 12, 5, 6};
        System.out.println(Arrays.toString(mergeSort(array)));
        mergeSortInPlace(array, 0, array.length);
        System.out.println(Arrays.toString(array));

    }
    //------ Time complexity of Merge Sort-------
    // We are diving the array into 2 parts and then again 2 parts just like binary search.
    // This diving is taking log(n) steps.
    // Then we are merging the two parts. In every step we are merging n elements.
    // So, n * log(n) -> nlogn

    // Divide array into two parts
    // Get both parts sorted via recursion
    // Merge two sorted parts
    // This merge sort is creating a new copy of the array so it doesn't sort the original array
    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int[] mergedArr = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                mergedArr[k++] = first[i++];
            } else {
                mergedArr[k++] = second[j++];
            }
        }

        while (i < first.length) {
            mergedArr[k++] = first[i++];
        }

        while (j < second.length) {
            mergedArr[k++] = second[j++];
        }

        return mergedArr;
    }

    // This one doesn't create a new copy of the array but sort the original array
    public static void mergeSortInPlace(int[] arr, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start,  mid, end);
    }

    public static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mergedArr = new int[end - start];
        int i = start;
        int j = mid;
        int k = 0;
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                mergedArr[k++] = arr[i++];
            } else {
                mergedArr[k++] = arr[j++];
            }
        }

        while (i < mid) {
            mergedArr[k++] = arr[i++];
        }

        while (j < end) {
            mergedArr[k++] = arr[j++];
        }

        for (int l = 0; l < mergedArr.length; l++) {
            arr[start+l] = mergedArr[l];
        }
    }
}
 