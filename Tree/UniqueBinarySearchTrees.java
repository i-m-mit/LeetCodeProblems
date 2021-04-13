package Tree;

import java.util.ArrayList;

import CommonDS.TreeNode;

/**
 * UniqueBinarySearchTrees
 */
public class UniqueBinarySearchTrees {

    public ArrayList<TreeNode> generateTrees(int a) {
        return constructTrees(1, a);
    }

    private ArrayList<TreeNode> constructTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> leftSubtree = constructTrees(start, i - 1);

            ArrayList<TreeNode> rightSubtree = constructTrees(i + 1, end);

            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees o = new UniqueBinarySearchTrees();
        System.out.println(o.generateTrees(3));
    }
}