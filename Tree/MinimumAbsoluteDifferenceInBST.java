package Tree;

import CommonDS.TreeNode;

public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    TreeNode prevNode;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        if (prevNode != null)
            min = Math.min(min, node.val - prevNode.val);
        prevNode = node;
        inorder(node.right);
    }

    public static void main(String[] args) {

    }
}
