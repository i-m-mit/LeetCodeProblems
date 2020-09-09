package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class TrimBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;
        if (root.val > R)
            return trimBST(root.left, L, R);
        if (root.val < L)
            return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        TrimBinarySearchTree o = new TrimBinarySearchTree();
        TreeNode output = o.trimBST(root, 1, 2);
        System.out.println(output);
    }
}
