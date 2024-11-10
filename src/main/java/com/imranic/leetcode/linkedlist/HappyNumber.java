package com.imranic.leetcode.linkedlist;

import java.util.Map;

// 202. Happy Number
// https://leetcode.com/problems/happy-number
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(2));
    }

    // This solution use similar approach as
    // Slow and fast pointer we used for linked list
    // As the number's repeat(cycle) at one point if it's not happy
    // So we can check if slow == fast, if yes then there is a cycle, we will never get 1
    // This problem can also be solved using HashSet
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while (slow != fast);

        return slow == 1;
    }

    private int findSquare(int n) {
        int square = 0;
        while (n > 0) {
            int rem = n % 10;
            square += rem * rem;
            n = n / 10;
        }
        return square;
    }
}
