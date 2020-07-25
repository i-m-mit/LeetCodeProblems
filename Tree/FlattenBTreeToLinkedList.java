package Tree;

import java.util.Stack;

import CommonDS.TreeNode;
import Util.InputHelper;

public class FlattenBTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        
        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode itr = root;
        while (itr.right != null) {
            itr = itr.right;
        }
        itr.right = right;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        FlattenBTreeToLinkedList o = new FlattenBTreeToLinkedList();
        o.flatten(root);
        System.out.println("Completed!!");
    }
}