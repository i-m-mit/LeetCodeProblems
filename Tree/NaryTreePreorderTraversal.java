package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import CommonDS.NaryTreeNode;
import Util.InputHelper;
import Util.ListToString;

public class NaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(NaryTreeNode root) {
        if (root == null) {
            return null;
        }
        res.add(root.val);
        if (root.children != null) {
            for (NaryTreeNode node : root.children) {
                preorder(node);
            }
        }
        return res;
    }

    public List<Integer> preorderV1(NaryTreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<NaryTreeNode> stack = new Stack<>();
        stack.add(root);
        NaryTreeNode cur;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.add(cur.children.get(i));
            }

        }
        return res;
    }

    public static void main(String[] args) {
        NaryTreeNode root = InputHelper.argsToNaryTreeNode(args);
        NaryTreePreorderTraversal o = new NaryTreePreorderTraversal();
        System.out.println(ListToString.convertListToString(o.preorderV1(root)));
    }
}