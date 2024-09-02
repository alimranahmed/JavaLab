package com.imranic.leetcode;

// 1342. Number of Steps to Reduce a Number to Zero
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero
public class ReduceSteps {
    public static void main(String[] args) {
        System.out.println((new ReduceSteps()).numberOfSteps(123));
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps += 1;
        }
        return steps;
    }
}
