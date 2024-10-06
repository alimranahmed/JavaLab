package com.imranic.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] list = {5, 4, 3, 2, 1};
        sort(list);
        System.out.printf(Arrays.toString(list));
    }

    public static void sort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    swap(list, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    public static void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
