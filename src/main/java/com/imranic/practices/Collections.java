package com.imranic.practices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // Lambda
        list.add(5);
        list.add(50);
        list.forEach(System.out::println);

        // Local Date
        LocalDate today = LocalDate.now();
        System.out.println(today.plusDays(3));

        // Stream
        List<String> names = Arrays.asList("Bob", "Charlie", "Alice");

        List<String> sortedNames = names.stream()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(sortedNames);

        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5}, 10));
    }

    public static int binarySearch(int[] nums, int n) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == n) {
                return mid;
            } else if (n > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
