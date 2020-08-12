package DynamicProgramming;

import java.util.Arrays;

import Util.InputHelper;

public class TargetSum {
    // Brute Force Approach
    int count;

    public int findTargetSumWays(int[] nums, int S) {
        count = 0;
        calculateCount(nums, 0, 0, S);
        return count;
    }

    private void calculateCount(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            count += sum == S ? 1 : 0;
        } else {
            calculateCount(nums, i + 1, sum - nums[i], S);
            calculateCount(nums, i + 1, sum + nums[i], S);
        }
    }

    // Recursion with memoization
    public int findTargetSumWaysV1(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }

    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }

    // 2-D DP Approach
    public int findTargetSumWaysV2(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }

    // 1-D DP Approach
    public int findTargetSumWaysV3(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        int S = Integer.parseInt(args[1]);
        long start = System.nanoTime();
        TargetSum o = new TargetSum();
        long end = System.nanoTime();
        long elapsedTime = end - start;
        System.out.println("Total possible ways: " + o.findTargetSumWaysV3(input, S));
        System.out.println("Time Escaped: " + elapsedTime);
    }
}