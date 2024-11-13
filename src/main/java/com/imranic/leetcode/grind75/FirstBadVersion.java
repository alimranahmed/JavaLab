package com.imranic.leetcode.grind75;

import java.util.Random;

// 278. First Bad Version
// https://leetcode.com/problems/first-bad-version
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(5));
    }

    // Binary search for the first bad version
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int badVersion = 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                badVersion = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return badVersion;
    }

    // This is a simulated method of Leetcode's internal method
    public boolean isBadVersion(int n) {
        return (new Random()).nextBoolean();
    }
}
