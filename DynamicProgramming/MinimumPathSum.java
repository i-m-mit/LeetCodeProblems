package DynamicProgramming;

import Util.InputHelper;

public class MinimumPathSum {

    // First Approach - Iterative approach with Dynamic Programming
    private int[][] dp;

    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0 && i == 0) {
                    dp[i][j] = grid[i][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(getDpValue(i - 1, j), getDpValue(i, j - 1));
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    private int getDpValue(int x, int y) {
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        return dp[x][y];
    }

    // Second Approach - Recursion with memoization
    public int minPathSumV1(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if (row == grid.length - 1 && col == grid[0].length - 1)
            return grid[row][col];
        if (memo[row][col] != 0)
            return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if (row < grid.length - 1)
            rowInc = minPathSumHelper(grid, row + 1, col, memo);
        if (col < grid[0].length - 1)
            colInc = minPathSumHelper(grid, row, col + 1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }

    public static void main(String[] args) {
        int[][] input = InputHelper.stringTo2DIntegerArray(args);
        MinimumPathSum o = new MinimumPathSum();
        System.out.println("Minimum Path sum : " + o.minPathSumV1(input));
    }
}