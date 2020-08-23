package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.TreeNode;
import Util.InputHelper;

public class IncreasingOrderSearchTree {

    List<Integer> nodes;

    public TreeNode increasingBST(TreeNode root) {
        nodes = new ArrayList<>();
        traverse(root);
        TreeNode newRoot = new TreeNode(nodes.get(0));
        TreeNode cur = newRoot;
        for (int i = 1; i < nodes.size(); i++) {
            cur.right = new TreeNode(nodes.get(i));
            cur = cur.right;
        }
        return newRoot;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        nodes.add(node.val);
        traverse(node.right);
    }

    TreeNode cur;

    public TreeNode increasingBSTV1(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null)
            return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        IncreasingOrderSearchTree o = new IncreasingOrderSearchTree();
        TreeNode newRoot = o.increasingBSTV1(root);
        System.out.println(newRoot);
    }
}