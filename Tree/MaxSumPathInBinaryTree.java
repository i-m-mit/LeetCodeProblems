package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

/**
 * MaxSumPathInBinaryTree
 */
public class MaxSumPathInBinaryTree {
    int max;

    public int maxPathSum(TreeNode A) {
        max = Integer.MIN_VALUE;
        maxSum(A, Integer.MIN_VALUE);
        return max;
    }

    private int maxSum(TreeNode A, int n) {
        if (A != null && A.val > max) {
            max = A.val;
        }
        if (A.left == null && A.right == null) {
            return A.val;
        }
        if (A.left == null) {
            return A.right.val;
        }
        if (A.right == null) {
            return A.left.val;
        }

        int rightSum = maxSum(A.right, n);
        int leftSum = maxSum(A.left, n);
        int m1 = Math.max(leftSum, rightSum);
        int m = Math.max(m1 + A.val, A.val);
        n = Math.max(n, Math.max(m1 + A.val, A.val));
        max = Math.max(max, Math.max(leftSum + rightSum + A.val, m));
        return n;
    }

    public static void main(String[] args) {
        TreeNode A = InputHelper.argsToTreeNode(args);
        MaxSumPathInBinaryTree o = new MaxSumPathInBinaryTree();
        System.out.println(o.maxPathSum(A));
    }
}