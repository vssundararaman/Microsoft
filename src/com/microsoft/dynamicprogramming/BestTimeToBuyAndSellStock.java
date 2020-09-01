package com.microsoft.dynamicprogramming;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};

        System.out.println (maxProfit (prices));

        System.out.println (maxProfit1 (prices));
    }

    static int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            } else if (prices[i] - minValue > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }

        return maxProfit;
    }

    static int maxProfit1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max (max, prices[i] - min);
            }
        }

        return max;
    }
}
