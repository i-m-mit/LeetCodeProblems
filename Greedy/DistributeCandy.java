package Greedy;

import Util.InputHelper;

/**
 * DistributeCandy
 */
public class DistributeCandy {
    public int candy(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int min = 0;
        for (int i = 0; i < n; i++) {
            min += Math.max(left[i], right[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        DistributeCandy o = new DistributeCandy();
        System.out.println(o.candy(A));
    }
}