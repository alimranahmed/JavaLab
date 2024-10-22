package com.imranic.leetcode.binarysearch;

// 69. Sqrt(x)
// https://leetcode.com/problems/sqrtx
public class SquareRoot {
    public static void main(String[] args) {
        System.out.println((new SquareRoot()).mySqrt(8));
    }

    public int mySqrt(int x) {
        if(x == 1 || x == 0) {
            return x;
        }

        int start = 0;
        int end = x;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(mid * mid == x) {
                return mid;
            } else if((long)mid * mid < (long)x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
