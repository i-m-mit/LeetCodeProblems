package Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import CommonDS.TreeNode;
import Util.InputHelper;

public class TwoSumInBST {
    // Inorder order Approach
    List<Integer> list;

    public boolean findTarget(TreeNode root, int k) {
        list = new ArrayList<>();
        inorder(root);
        int lo = 0;
        int hi = list.size() - 1;
        int sum;
        while (lo < hi) {
            sum = list.get(lo) + list.get(hi);
            if (sum > k) {
                hi--;
            } else if (sum < k) {
                lo++;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            list.add(node.val);
            inorder(node.right);
        }
    }

    // Hashset Approach
    public boolean findTargetV1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    public boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    // BFS + Hashset Approach
    public boolean findTargetV2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        TwoSumInBST o = new TwoSumInBST();

        System.out.println(o.findTarget(root, 9));
    }
}
