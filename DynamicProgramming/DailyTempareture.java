package DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

import Util.ArrayToString;
import Util.InputHelper;

public class DailyTempareture {

    // Brute-Force Approach
    public int[] dailyTemperatures(int[] T) {
        int[] retArray = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            retArray[i] = 0;
            for (int j = i; j < T.length; j++) {
                if (T[j] > T[i]) {
                    retArray[i] = j - i;
                    break;
                }
            }
        }

        return retArray;
    }

    // Next Array Approach - Complexity O(WN) -> W=71 -> O(N)
    public int[] dailyTemperaturesV1(int[] T) {
        int[] ans = new int[T.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = T.length - 1; i >= 0; --i) {
            int warmer_index = Integer.MAX_VALUE;
            for (int t = T[i] + 1; t <= 100; ++t) {
                if (next[t] < warmer_index)
                    warmer_index = next[t];
            }
            if (warmer_index < Integer.MAX_VALUE)
                ans[i] = warmer_index - i;
            next[T[i]] = i;
        }
        return ans;
    }

    // Stack Approach
    public int[] dailyTemperaturesV2(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()])
                stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    // Without Stack Implementation
    public int[] dailyTemperaturesV3(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }
        int[] days = new int[T.length];
        days[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            if (T[i] < T[i + 1]) {
                days[i] = 1;
            } else {
                for (int k = i + 1;; k = k + days[k]) {
                    if (T[k] > T[i]) {
                        days[i] = k - i;
                        break;
                    }
                    if (days[k] == 0) {
                        days[i] = 0;
                        break;
                    }
                }
            }
        }
        return days;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        DailyTempareture o = new DailyTempareture();

        int[] retArray = o.dailyTemperaturesV3(input);
        System.out.println(ArrayToString.convert1DArrayToString(retArray));
        System.out.println("[1, 1, 4, 2, 1, 1, 0, 0]");
    }
}