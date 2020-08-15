package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.TreeNode;
import Util.InputHelper;

public class LowestCommonAncestor {
    // Brute Force Approach
    List<TreeNode> acList;
    TreeNode commonAc;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        acList = new ArrayList<>();
        findNode(root, p);
        findNode(root, q);

        return commonAc;
    }

    private boolean findNode(TreeNode node, TreeNode findNode) {
        if (node == null) {
            return false;
        }
        boolean retVal = false;
        if (node == findNode) {
            retVal = true;
        } else {
            retVal = findNode(node.left, findNode) || findNode(node.right, findNode);
        }
        if (retVal) {
            if (!acList.contains(node)) {
                acList.add(node);

            } else {
                commonAc = node;
                return false;
            }
        }

        return retVal;
    }

    // Recursive Approach
    private TreeNode ans = null;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        TreeNode p = root.left;
        TreeNode q = root.right;
        LowestCommonAncestor o = new LowestCommonAncestor();
        TreeNode output = o.lowestCommonAncestorV1(root, p, q);
        System.out.println(output.val);
    }
}