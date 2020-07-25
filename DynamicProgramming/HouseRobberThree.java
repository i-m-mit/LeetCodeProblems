package DynamicProgramming;

import CommonDS.TreeNode;
import Util.InputHelper;

public class HouseRobberThree {
    final int ROBBED = 0;
    final int UNROBBED = 1;

    public int rob(TreeNode root) {
        int[] dp = dfs(root);
        return Math.max(dp[ROBBED], dp[UNROBBED]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[2];
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int[] dp = new int[2];
        dp[ROBBED] = left[UNROBBED] + right[UNROBBED] + node.val;
        dp[UNROBBED] = Math.max(left[ROBBED], left[UNROBBED]) + Math.max(right[ROBBED], right[UNROBBED]);

        return dp;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        HouseRobberThree o = new HouseRobberThree();
        System.out.println("Maximum amount of money you can rob : " + o.rob(root));
    }
}