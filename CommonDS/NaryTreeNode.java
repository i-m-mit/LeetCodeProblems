package CommonDS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NaryTreeNode {
    public int val;
    public List<NaryTreeNode> children;

    public NaryTreeNode() {
    }

    public NaryTreeNode(int _val) {
        val = _val;
    }

    public NaryTreeNode(int _val, List<NaryTreeNode> _children) {
        val = _val;
        children = _children;
    }

    public static NaryTreeNode createTree(Integer[] nodes) {
        if (nodes.length == 0)
            return null;
        NaryTreeNode root = new NaryTreeNode(nodes[0], new ArrayList<>());
        Queue<NaryTreeNode> q = new ArrayDeque<>();
        q.add(root);
        for (int i = 2; i < nodes.length; i++) {
            NaryTreeNode currentNode = q.poll();
            while (i < nodes.length && nodes[i] != null) {
                NaryTreeNode node = new NaryTreeNode(nodes[i++], new ArrayList<>());
                currentNode.children.add(node);
                q.add(node);
            }
        }

        return root;
    }
}