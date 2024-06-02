package com.imranic.algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] list = {4, 5, 7, 0, 1, 3, 2};
        (new BubbleSort()).sort(list);
        System.out.println("List "+Arrays.toString(list));
    }

    public void sort(int[] list) {
        boolean swapped;
        for (int i = 0; i < list.length; i++) {
            swapped = false;
            for (int j = 1; j < list.length - i; j++){
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
