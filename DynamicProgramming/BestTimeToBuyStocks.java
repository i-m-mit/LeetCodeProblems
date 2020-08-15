package DynamicProgramming;

import Util.InputHelper;

public class BestTimeToBuyStocks {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int idle = 0;
        int bought = -prices[0];
        int sold = Integer.MIN_VALUE;
        int prevIdle;
        for (int i = 1; i < prices.length; i++) {
            prevIdle = idle;
            idle = idle >= sold ? idle : sold;
            sold = bought + prices[i];
            bought = bought >= prevIdle - prices[i] ? bought : prevIdle - prices[i];
        }
        return idle >= sold ? idle : sold;
    }

    public static void main(String[] args) {
        int[] prices = InputHelper.stringToIntegers(args);
        BestTimeToBuyStocks o = new BestTimeToBuyStocks();
        System.out.println("Maximum profit : " + o.maxProfit(prices));
    }
}