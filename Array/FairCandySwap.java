package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Util.InputHelper;

public class FairCandySwap {
    // Brute Force Approach
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] ret = new int[2];
        int sumA = 0;
        int sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }
        int sum = (sumA + sumB) / 2;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (sumA - A[i] + B[j] == sum) {
                    return new int[] { A[i], B[j] };
                }
            }
        }

        return ret;
    }

    public int[] fairCandySwapV1(int[] A, int[] B) {
        int sa = 0, sb = 0; // sum of A, B respectively
        for (int x : A)
            sa += x;
        for (int x : B)
            sb += x;
        int delta = (sb - sa) / 2;
        // If Alice gives x, she expects to receive x + delta

        Set<Integer> setB = new HashSet<>();
        for (int x : B)
            setB.add(x);

        for (int x : A)
            if (setB.contains(x + delta))
                return new int[] { x, x + delta };

        throw null;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        int[] B = InputHelper.stringToIntegers(args, 1);

        FairCandySwap o = new FairCandySwap();
        System.out.println(Arrays.toString(o.fairCandySwap(A, B)));
    }
}
