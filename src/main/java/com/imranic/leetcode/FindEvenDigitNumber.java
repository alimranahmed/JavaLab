package com.imranic.leetcode;

import java.util.Arrays;

// 1295. Find Numbers with Event Number of Digits
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits
public class FindEvenDigitNumber {
    public static void main(String[] args) {
        int[] nums1= {59, 593, 3939};
        int totalEvenDigits = (new FindEvenDigitNumber()).findNumbers(nums1);
        System.out.println(Arrays.toString(nums1)+" has total event digit: "+totalEvenDigits);
    }

    public int findNumbers(int[] nums){
        int totalEventDigits = 0;
        for (int num: nums) {
            int numberOfDigits = ((int)(Math.log10(num)) + 1);
            if (numberOfDigits % 2 == 0) {
                totalEventDigits++;
            }
        }

        return totalEventDigits;
    }
}
