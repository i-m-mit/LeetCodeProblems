package DynamicProgramming;

/**
 * BestTimeToBuyStocksIII
 */
public class BestTimeToBuyStocksIII {
    public int maxProfit(final int[] A) {
        int n = A.length;
        if (n < 2)
            return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        right[n - 1] = 0;
        int lMin = A[0];
        int rMax = A[n - 1];
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i] - lMin);
            lMin = Math.min(lMin, A[i]);
        }
        for (int j = n - 2; j >= 0; j--) {
            right[j] = Math.max(right[j + 1], rMax - A[j]);
            rMax = Math.max(rMax, A[j]);
        }
        maxProfit = right[0];
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i - 1] + right[i]);
        }

        return maxProfit;
    }
}