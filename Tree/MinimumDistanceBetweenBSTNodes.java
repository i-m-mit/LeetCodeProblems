package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.TreeNode;
import Util.InputHelper;

public class MinimumDistanceBetweenBSTNodes {
    List<Integer> list;

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);

        int min = Integer.MAX_VALUE;
        int cur;
        for (int i = 0; i < list.size() - 1; i++) {
            cur = list.get(i + 1) - list.get(i);
            if (cur < min) {
                min = cur;
            }
        }
        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBSTV1(TreeNode root) {
        if (root.left != null)
            minDiffInBST(root.left);
        if (pre != null)
            res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null)
            minDiffInBST(root.right);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        MinimumAbsoluteDifferenceInBST o = new MinimumAbsoluteDifferenceInBST();

        System.out.println("Minimum Distance: " + o.getMinimumDifference(root));
    }
}
