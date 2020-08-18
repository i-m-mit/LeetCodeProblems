package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class RangeSumOfBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                sum += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        int L = 7;
        int R = 15;
        RangeSumOfBST o = new RangeSumOfBST();
        System.out.println("Sum: " + o.rangeSumBST(root, L, R));
    }
}