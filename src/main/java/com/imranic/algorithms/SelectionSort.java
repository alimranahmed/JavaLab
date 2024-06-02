package com.imranic.algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = {12, 3, 59, 20, 1, 6, 0};
        (new SelectionSort()).sort(list);
        System.out.println(Arrays.toString(list));
    }

    public void sort(int[] list) {
        for (int i = list.length - 1; i >= 1; i--) {
            int maxIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (list[maxIndex] < list[j]) {
                    maxIndex = j;
                }
            }
            swap(list, maxIndex, i);
        }
    }

    public static void swap(int[] list, int first, int second) {
        int temp = list[first];
        list[first] = list[second];
        list[second] = temp;
    }
}
