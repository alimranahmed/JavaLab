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

            int temp = list[i];
            list[i] = list[maxIndex];
            list[maxIndex] = temp;
        }
    }
}
