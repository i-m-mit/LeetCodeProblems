package DynamicProgramming;

import Util.InputHelper;

public class BestTimeToBuyStocksII {

    // Dynamic Programming Approach
    public int maxProfit(int[] prices) {
        if (prices.length <= 0) {
            return 0;
        }
        int idle = 0;
        int oldIdle;
        int bought = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            oldIdle = idle;
            idle = Math.max(idle, bought + prices[i]);
            bought = Math.max(bought, oldIdle - prices[i]);
        }
        return Math.max(idle, bought);
    }

    // Greedy Approach
    public int maxProfitV1(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = InputHelper.stringToIntegers(args);
        BestTimeToBuyStocksII o = new BestTimeToBuyStocksII();
        System.out.println("Max Profit: " + o.maxProfit(prices));
    }
}