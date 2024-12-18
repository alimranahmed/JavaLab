package com.imranic.algorithms.sorting;

import java.util.Arrays;

// When there is a range of numbers(eg. 1 - n) defined,
// Always use cyclic sort
public class CyclicSort {
    public static void main(String[] args) {
        int[] list = {3, 5, 2, 1, 4};
        sort(list);
        System.out.printf(Arrays.toString(list));
    }

    // Cyclic sort means a range will be defined and those have to sorted
    // For example: let say we have all the number between 5 - 10 but in an unsorted manner.
    // Eg.. Input array: 6, 7, 5, 8, 10, 9
    // All we have to do is sort them like output: 5, 6, 7, 8, 9, 10
    public static void sort(int[] list) {
        int i = 0;

        while (i < list.length) {
            int correctIndex = list[i] - 1;
            if (list[i] != list[correctIndex]) {
                swap(list, i, correctIndex);
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
