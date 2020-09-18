package Common;

import java.util.Arrays;
import java.util.PriorityQueue;

import Util.InputHelper;

public class MaximizeSumOfArrayAfterKNegations {
    // Priority Queue Approach
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : A) {
            queue.add(i);
        }
        int cur;
        for (int i = 0; i < K; i++) {
            cur = queue.poll();
            queue.add(-cur);
        }

        int sum = 0;
        for (Integer i : queue) {
            sum += i;
        }
        return sum;
    }

    // For loop Approach
    public int largestSumAfterKNegationsV1(int[] A, int K) {
        Arrays.sort(A);
        int sum = 0;
        int lIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[lIndex]) > Math.abs(A[i])) {
                lIndex = i;
            }
            if (K > 0) {
                if (A[i] < 0) {
                    A[i] = Math.abs(A[i]);
                } else {
                    break;
                }
                K--;
            }

        }
        while (K > 0) {
            A[lIndex] = -1 * A[lIndex];
            K--;
        }
        for (int i : A) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        MaximizeSumOfArrayAfterKNegations o = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(o.largestSumAfterKNegationsV1(A, 4));
    }
}