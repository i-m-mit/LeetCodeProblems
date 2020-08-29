package Tree;

import CommonDS.NaryTreeNode;
import Util.InputHelper;

public class MaximumDepthNaryTree {
    public int maxDepth(NaryTreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(NaryTreeNode node, int level) {
        if (node == null) {
            return 0;
        }
        int retLevel = level + 1;
        for (NaryTreeNode chiNode : node.children) {
            retLevel = Math.max(retLevel, dfs(chiNode, level + 1));
        }
        return retLevel;
    }

    public static void main(String[] args) {
        NaryTreeNode root = InputHelper.argsToNaryTreeNode(args);
        MaximumDepthNaryTree o = new MaximumDepthNaryTree();
        System.out.println("Depth of Tree: " + o.maxDepth(root));
    }
}