package com.imranic.algorithms.searching;

import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {5, 23, -11, 26, 60, 30};
        int target = 60;
        int foundIndex = search(nums, 60);
        System.out.println("---Linear Search---");
        System.out.println("List: "+ Arrays.toString(nums));
        System.out.println(target+" is found in index "+foundIndex);
    }

    public static int search(int[] list, int target) {
        if (list.length == 0) {
            return -1;
        }

        for (int index = 0; index < list.length; index++) {
            if (list[index] == target) {
                return index;
            }
        }
        return -1;
    }
}
