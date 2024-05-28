package com.imranic.algorithms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] list = {1, 5, 10, 20, 55, 66, 90, 102, 150};

        System.out.println("----Binary Search----");
        System.out.println("List: "+ Arrays.toString(list));

        int target = 10;
        int foundIndex = (new BinarySearch()).search(list, target);

        System.out.println(target+" found at index: "+foundIndex);

    }

    public int search(int[] list, int target) {
        if (list.length == 0) {
            return -1;
        }

        int start = 0;
        int end = list.length - 1;
        while(start <= end) {
            //int mid = (start + end) / 2; // this may give int out of range error as we are adding start + end
            int mid = start + (end - start) / 2;

            if (target > list[mid]) {
                start = mid + 1;
            } else if (target < list[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
