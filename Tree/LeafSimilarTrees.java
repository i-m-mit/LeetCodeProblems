package Tree;

import java.util.LinkedList;
import java.util.Queue;

import CommonDS.TreeNode;
import Util.InputHelper;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        dfs(root1, q1);
        dfs(root2, q2);
        if (q1.size() != q2.size()) {
            return false;
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.poll() != q2.poll()) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode node, Queue<Integer> q) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            q.add(node.val);
            return;
        }
        dfs(node.left, q);
        dfs(node.right, q);
    }

    public static void main(String[] args) {
        TreeNode root1 = InputHelper.argsToTreeNode(args);
        TreeNode root2 = InputHelper.argsToTreeNode(args, 1);
        LeafSimilarTrees o = new LeafSimilarTrees();

        System.out.println(o.leafSimilar(root1, root2));
    }
}