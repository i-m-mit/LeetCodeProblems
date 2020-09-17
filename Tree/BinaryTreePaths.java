package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.TreeNode;
import Util.InputHelper;
import Util.ListToString;

public class BinaryTreePaths {
    List<String> retList;

    public List<String> binaryTreePaths(TreeNode root) {
        retList = new ArrayList<>();
        dfs(root, new StringBuffer());
        return retList;
    }

    private void dfs(TreeNode node, StringBuffer buffer) {
        if (node != null) {
            buffer.append(node.val);
            if (node.left == null && node.right == null) {
                retList.add(buffer.toString());
                return;
            }
            buffer.append("->");
            if (node.left != null) {
                dfs(node.left, new StringBuffer(buffer));
            }
            if (node.right != null) {
                dfs(node.right, new StringBuffer(buffer));
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        BinaryTreePaths o = new BinaryTreePaths();
        System.out.println(ListToString.convertListToString(o.binaryTreePaths(root)));
    }
}
