package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.TreeNode;
import Util.InputHelper;

public class KthSmallestElement {
    private List<Integer> arr;

    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        traverse(root);
        return (int) arr.get(k - 1);
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        arr.add(node.val);
        traverse(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        KthSmallestElement o = new KthSmallestElement();
        int k = Integer.parseInt(args[1]);
        int output = o.kthSmallest(root, k);
        System.out.println(k + "th Smallest Element : " + output);
    }
}