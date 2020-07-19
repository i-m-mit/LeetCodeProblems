package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import CommonDS.TreeNode;
import Util.InputHelper;
import Util.ListToString;

public class BinaryTreeTraverse {
    // Recursive Approach
    List<Integer> retList;

    public List<Integer> inorderTraversal(TreeNode root) {
        retList = new ArrayList<>();
        traverseNode(root);
        return retList;
    }

    private void traverseNode(TreeNode node) {
        if (node == null) {
            return;
        }
        traverseNode(node.left);
        retList.add(node.val);
        traverseNode(node.right);
    }

    // Iterative Approach - using Stack
    public List<Integer> inorderTraversalV1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    // Threaded tree Approach
    public List<Integer> inorderTraversalV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        BinaryTreeTraverse o = new BinaryTreeTraverse();
        List<Integer> output = o.inorderTraversal(root);
        System.out.println(ListToString.convertListToString(output));
    }
}