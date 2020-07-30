package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class TreeFromPreorderAndInorder {

    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(preorder, inorder, 0, inorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (preIndex >= preorder.length || start >= end) {
            return null;
        }

        int val = preorder[preIndex++];
        TreeNode node = new TreeNode(val);
        int index = 0;
        for (int i = start; i < end; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }

        node.left = buildTree(preorder, inorder, start, index);
        node.right = buildTree(preorder, inorder, index + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = InputHelper.stringToIntegers(args, 0);
        int[] inorder = InputHelper.stringToIntegers(args, 1);

        TreeFromPreorderAndInorder o = new TreeFromPreorderAndInorder();
        TreeNode result = o.buildTree(preorder, inorder);
    }
}