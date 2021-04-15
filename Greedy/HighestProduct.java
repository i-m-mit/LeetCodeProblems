package Greedy;

import Util.InputHelper;

/**
 * HighestProduct
 */
public class HighestProduct {

    public int maxp3(int[] A) {
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }
        int negativeMax1 = Integer.MAX_VALUE;
        int negativeMax2 = Integer.MAX_VALUE;
        int positiveMax1 = Integer.MIN_VALUE;
        int positiveMax2 = Integer.MIN_VALUE;
        int positiveMax3 = Integer.MIN_VALUE;
        for (int i : A) {
            if (i >= positiveMax1) {
                positiveMax3 = positiveMax2;
                positiveMax2 = positiveMax1;
                positiveMax1 = i;
            } else if (i >= positiveMax2) {
                positiveMax3 = positiveMax2;
                positiveMax2 = i;
            } else if (i >= positiveMax3) {
                positiveMax3 = i;
            }
            if (i <= negativeMax1) {
                negativeMax2 = negativeMax1;
                negativeMax1 = i;
            } else if (i <= negativeMax2) {
                negativeMax2 = i;
            }
        }

        return Math.max(positiveMax1 * positiveMax2 * positiveMax3, positiveMax1 * negativeMax2 * negativeMax1);
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        HighestProduct o = new HighestProduct();
        System.out.println(o.maxp3(A));
    }
}