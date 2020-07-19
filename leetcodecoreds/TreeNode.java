package leetcodecoreds;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] nodes) {
        if (nodes.length == 0)
            return null;
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode currentNode = q.poll();
            if (nodes[i] != null) {
                currentNode.left = new TreeNode(nodes[i]);
                q.add(currentNode.left);
            }
            i++;
            if (i < nodes.length && nodes[i] != null) {
                currentNode.right = new TreeNode(nodes[i]);
                q.add(currentNode.right);
            }
        }

        return root;
    }
}