package com.imranic.leetcode;

// 1672. Richest Customer Wealth
// https://leetcode.com/problems/richest-customer-wealth/
public class MaximumWealth {
    public static void run() {
        int[][] input = {{1,2,3},{3,2,1}};
        int output = (new MaximumWealth()).maximumWealth(input);
        System.out.println("Maximum wealth is: "+output);
    }

    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] accountPerson : accounts) {
            int wealth = 0;
            for (int account : accountPerson) {
                wealth += account;
            }

            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
