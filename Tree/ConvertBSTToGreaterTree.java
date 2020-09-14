package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class ConvertBSTToGreaterTree {
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        ConvertBSTToGreaterTree o = new ConvertBSTToGreaterTree();
        TreeNode output = o.convertBST(root);
        System.out.println(output);
    }
}
