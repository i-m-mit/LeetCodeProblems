package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class CousinsInBinaryTree {
    int[][] check;

    public boolean isCousins(TreeNode root, int x, int y) {
        check = new int[2][2];
        dfs(root, 0, x, y);
        return check[0][0] == check[1][0] && check[0][1] != check[1][1];
    }

    private void dfs(TreeNode node, int level, int x, int y) {
        if (node != null) {
            int left = node.left != null ? node.left.val : -1;
            int right = node.right != null ? node.right.val : -1;
            level++;
            if (left == x || right == x) {
                check[0][0] = level;
                check[0][1] = node.val;
            }
            if (left == y || right == y) {
                check[1][0] = level;
                check[1][1] = node.val;
            }
            dfs(node.left, level, x, y);
            dfs(node.right, level, x, y);
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        CousinsInBinaryTree o = new CousinsInBinaryTree();
        System.out.println(o.isCousins(root, 5, 4));
    }
}