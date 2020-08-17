package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class FinalPricesWithSpecialDiscount {
    public int[] finalPrices(int[] prices) {
        int[] discountedPrices = new int[prices.length];
        int discount;
        for (int i = 0; i < prices.length; i++) {
            discount = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    discount = prices[j];
                    break;
                }
            }
            discountedPrices[i] = prices[i] - discount;
        }
        return discountedPrices;
    }

    public static void main(String[] args) {
        int[] prices = InputHelper.stringToIntegers(args);
        FinalPricesWithSpecialDiscount o = new FinalPricesWithSpecialDiscount();

        System.out.println(
                "Final Prices with Discount: \n" + ArrayToString.convert1DArrayToString(o.finalPrices(prices)));
    }
}