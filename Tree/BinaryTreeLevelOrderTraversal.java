package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CommonDS.TreeNode;
import Util.InputHelper;
import Util.ListToString;

public class BinaryTreeLevelOrderTraversal {

    // DFS Approach
    List<List<Integer>> retList;

    public List<List<Integer>> levelOrder(TreeNode root) {
        retList = new ArrayList<>();
        traverse(root, 0);
        return retList;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null)
            return;

        try {
            retList.get(level).add(node.val);
        } catch (IndexOutOfBoundsException e) {

            List<Integer> list;
            list = new ArrayList<>();
            list.add(node.val);
            retList.add(list);
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderV1(TreeNode root) {
        retList = new ArrayList<>();
        Queue<TreeNode> q1;
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);
        List<Integer> list;
        while (!q2.isEmpty()) {
            q1 = new LinkedList<>(q2);
            q2.clear();
            list = new ArrayList<>();
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                list.add(node.val);
                if (node.left != null) {
                    q2.add(node.left);
                }
                if (node.right != null) {
                    q2.add(node.right);
                }
            }
            retList.add(list);
        }
        return retList;
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        BinaryTreeLevelOrderTraversal o = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> output = o.levelOrder(root);
        System.out.println(ListToString.convert2DListToString(output));
    }

}