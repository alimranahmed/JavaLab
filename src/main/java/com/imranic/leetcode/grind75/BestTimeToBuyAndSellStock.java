package com.imranic.leetcode.grind75;

// 121. Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int maxProfit = (new BestTimeToBuyAndSellStock())
                .maxProfit(new int[] {7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }

    /**
     * We are considering the 1st entry as buying price
     * Traverse through each price and consider them as sell price
     * If we find a new price that is less than buying price
     *      Then we make that new buy price
     * For each buy - sell price we are returning the max profit
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            int sell = prices[i];
            if(buy > sell) {
                buy = prices[i];
            }
            max = Math.max(max, sell - buy);
        }
        return max;
    }
}
