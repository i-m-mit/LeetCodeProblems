package Array;

import java.util.Arrays;

import Util.InputHelper;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] A) {
        int p = 0;
        int N = A.length;
        int[] ret = new int[N];
        while (p < N && A[p] < 0) {
            p++;
        }
        int n = p - 1;
        int k = 0;
        while (k < N) {
            if (n >= 0 && p < N) {
                if (-1 * A[n] < A[p]) {
                    ret[k++] = A[n] * A[n];
                    n--;
                } else {
                    ret[k++] = A[p] * A[p];
                    p++;
                }
            } else if (n >= 0) {
                ret[k++] = A[n] * A[n];
                n--;
            } else if (p < A.length) {
                ret[k++] = A[p] * A[p];
                p++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        SquaresOfSortedArray o = new SquaresOfSortedArray();
        System.out.println("Sorted Squares: " + Arrays.toString(o.sortedSquares(A)));
    }
}