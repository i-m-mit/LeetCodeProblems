package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class SumOfRootToLeafBinaryNumbers {
    int sum;

    public int sumRootToLeaf(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int cur) {
        if (node == null) {
            return;
        }
        cur = cur << 1 | node.val;
        if (node.left == null && node.right == null) {
            sum += cur;
        } else {
            dfs(node.left, cur);
            dfs(node.right, cur);
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        SumOfRootToLeafBinaryNumbers o = new SumOfRootToLeafBinaryNumbers();

        System.out.println("Sum: " + o.sumRootToLeaf(root));
    }
}