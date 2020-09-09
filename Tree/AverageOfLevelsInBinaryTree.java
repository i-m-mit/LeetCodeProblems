package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import CommonDS.TreeNode;
import Util.InputHelper;
import Util.ListToString;

public class AverageOfLevelsInBinaryTree {

    // Iterative Approach
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        Queue<TreeNode> q1;
        Queue<TreeNode> q2 = new LinkedList<>();
        q2.add(root);
        double sum;
        int count;
        TreeNode iter;
        while (!q2.isEmpty()) {
            q1 = q2;
            q2 = new LinkedList<>();
            sum = 0;
            count = q1.size();
            while (!q1.isEmpty()) {
                iter = q1.poll();
                sum += iter.val;
                if (iter.left != null) {
                    q2.add(iter.left);
                }
                if (iter.right != null) {
                    q2.add(iter.right);
                }
            }

            ret.add(sum / count);
        }

        return ret;
    }

    // DFS Recursive Approach
    List<Integer> count;
    List<Double> sum;

    public List<Double> averageOfLevelsV1(TreeNode root) {
        count = new ArrayList<>();
        sum = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= sum.size()) {
            sum.add(level, (double) node.val);
            count.add(level, 1);
        } else {
            count.set(level, count.get(level) + 1);
            sum.set(level, sum.get(level) + node.val);
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = InputHelper.argsToTreeNode(args);
        AverageOfLevelsInBinaryTree o = new AverageOfLevelsInBinaryTree();
        System.out.println("Averages: " + ListToString.convertListToString(o.averageOfLevelsV1(root)));
    }
}
