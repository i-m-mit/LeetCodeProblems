package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return findPath(root.left, sum - root.val) || findPath(root.right, sum - root.val);
    }

    private boolean findPath(TreeNode node, int sum) {
        if (node == null)
            return false;
        if (node.val == sum)
            return true;
        return findPath(node.left, sum - node.val) || findPath(node.right, sum - node.val);
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        PathSum o = new PathSum();
        System.out.println("RESULT : " + o.hasPathSum(root, 22));
    }
}