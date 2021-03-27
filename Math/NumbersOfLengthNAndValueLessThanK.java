package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Util.InputHelper;

public class NumbersOfLengthNAndValueLessThanK {
    public int solve(int[] A, int B, int C) {
        if (A.length == 0)
            return 0;
        int lengthC = Integer.toString(C).length();
        int temp = C;
        int n = A.length;
        int[] arrC = new int[lengthC];
        for (int j = 0; j < arrC.length; j++) {
            arrC[j] = temp % 10;
            temp /= 10;
        }
        if (lengthC > B) {
            if (A[0] == 0) {
                return (n - 1) * (int) Math.pow(n, B - 1);
            } else {
                return (int) Math.pow(n, B);
            }
        }
        if (lengthC < B) {
            return 0;
        }

        int ans = 0;
        int i = lengthC - 1;
        boolean breakLoop;
        while (i >= 0) {
            breakLoop = true;
            for (int j : A) {
                if (i == lengthC - 1 && j == 0) {
                    continue;
                }
                if (arrC[i] > j) {
                    ans += (int) Math.pow(n, i);
                } else if (arrC[i] == j) {
                    i--;
                    breakLoop = false;
                    break;
                }
            }
            if (breakLoop)
                break;
        }

        return ans;
    }

    int[] numToVec(int N) {
        List<Integer> digit = new ArrayList<>();
        while (N != 0) {
            digit.add(N % 10);
            N = N / 10;
        }
        if (digit.size() == 0) {
            digit.add(0);
        }

        Collections.reverse(digit);

        int[] toReturn = new int[digit.size()];
        for (int i = 0; i < digit.size(); i++) {
            toReturn[i] = digit.get(i);
        }
        return toReturn;
    }

    public int solveV1(int[] A, int B, int C) {
        int[] digit;
        int d = A.length;
        int d2;

        // convert number to digit array
        digit = numToVec(C);

        if (B > digit.length || d == 0) {
            // Case 1
            return 0;
        } else if (B < digit.length) {
            // Case 2
            if (A[0] == 0 && B != 1) {
                // contain 0
                return (int) ((d - 1) * Math.pow(d, B - 1));
            } else {
                return (int) Math.pow(d, B);
            }
        } else {
            // Case 3
            int[] dp = new int[B + 1];
            int[] lower = new int[11];
            for (int i = 0; i <= B; i++) {
                dp[i] = 0;
            }
            for (int i = 0; i <= 10; i++) {
                lower[i] = 0;
            }
            for (int i = 0; i < d; i++) {
                lower[A[i] + 1] = 1;
            }

            for (int i = 1; i <= 10; i++) {
                lower[i] = lower[i - 1] + lower[i];
            }

            boolean flag = true;
            dp[0] = 0;
            for (int i = 1; i <= B; i++) {
                d2 = lower[digit[i - 1]];
                dp[i] = dp[i - 1] * d;

                // For first index we can't use 0
                if (i == 1 && A[0] == 0 && B != 1) {
                    d2 = d2 - 1;
                }

                // Whether (i-1) digit of generated number can be equal to (i - 1) digit of C.
                if (flag) {
                    dp[i] += d2;
                }
                // Is digit[i - 1] present in A ?
                flag = flag & (lower[digit[i - 1] + 1] == lower[digit[i - 1]] + 1);
            }
            return dp[B];
        }
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        NumbersOfLengthNAndValueLessThanK o = new NumbersOfLengthNAndValueLessThanK();
        System.out.println("Result: " + o.solveV1(A, 2, 21));
    }
}