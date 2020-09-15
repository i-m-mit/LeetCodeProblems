package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CommonDS.TreeNode;
import Util.InputHelper;
import Util.ListToString;

public class BinaryTreeLevelOrderTraversalII {
    // BFS Appoach
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> q1;
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);
        TreeNode cur;
        List<Integer> curList;
        while (!q2.isEmpty()) {
            q1 = q2;
            q2 = new LinkedList<>();
            curList = new ArrayList<>();
            while (!q1.isEmpty()) {
                cur = q1.poll();
                if (cur.left != null) {
                    q2.add(cur.left);
                }
                if (cur.right != null) {
                    q2.add(cur.right);
                }
                curList.add(cur.val);
            }
            ret.add(0, curList);
        }
        return ret;
    }

    List<List<Integer>> retList;

    public List<List<Integer>> levelOrderBottomV1(TreeNode root) {
        retList = new ArrayList<>();
        dfs(root, 1);
        return retList;
    }

    private void dfs(TreeNode node, int level) {
        if (node != null) {
            List<Integer> cur;
            if (retList.size() < level) {
                cur = new ArrayList<>();
                retList.add(0, cur);
            } else {
                cur = retList.get(retList.size() - level);
            }
            cur.add(node.val);
            level++;

            dfs(node.left, level);
            dfs(node.right, level);
        }
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        BinaryTreeLevelOrderTraversalII o = new BinaryTreeLevelOrderTraversalII();
        System.out.println(ListToString.convert2DListToString(o.levelOrderBottomV1(root)));
    }
}
