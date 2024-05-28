package com.imranic.algorithms;

import java.util.Arrays;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        System.out.println("----Order Agnostic Binary Search----");

        int[] list = {1, 5, 10, 20, 55, 66, 90, 102, 150};
        System.out.println("List: "+ Arrays.toString(list));
        int target = 10;
        int foundIndex = (new OrderAgnosticBinarySearch()).search(list, target);
        System.out.println(target+" found at index: "+foundIndex);

        int[] list1 = {500, 400, 300, 150, 55, 50, 33, 23, 1, -1};
        System.out.println("List: "+ Arrays.toString(list1));
        int target1 = 150;
        int foundIndex1 = (new OrderAgnosticBinarySearch()).search(list1, target1);
        System.out.println(target1+" found at index: "+foundIndex1);

    }

    public int search(int[] list, int target) {
        if (list.length == 0) {
            return -1;
        }


        int start = 0;
        int end = list.length - 1;
        boolean isAsc = list[start] < list[end];
        while(start <= end) {
            //int mid = (start + end) / 2; // this may give int out of range error as we are adding start + end
            int mid = start + (end - start) / 2;

            if (target == list[mid]) {
                return mid;
            }
            if (isAsc) {
                if (target > list[mid]) {
                    start = mid + 1;
                } else if (target < list[mid]) {
                    end = mid - 1;
                }
            } else {
                if (target < list[mid]) {
                    start = mid + 1;
                } else if (target > list[mid]) {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
