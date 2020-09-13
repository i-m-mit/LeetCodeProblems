package Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import CommonDS.TreeNode;
import Util.InputHelper;

public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode t) {
        if (t == null)
            return "";
        if (t.left == null && t.right == null)
            return t.val + "";
        if (t.right == null)
            return t.val + "(" + tree2str(t.left) + ")";
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }

    public String tree2strV1(TreeNode t) {
        if (t == null)
            return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(t);
        Set<TreeNode> visited = new HashSet<>();
        StringBuffer s = new StringBuffer();
        while (!stack.isEmpty()) {
            t = stack.peek();
            if (visited.contains(t)) {
                stack.pop();
                s.append(")");
            } else {
                visited.add(t);
                s.append("(" + t.val);
                if (t.left == null && t.right != null)
                    s.append("()");
                if (t.right != null)
                    stack.push(t.right);
                if (t.left != null)
                    stack.push(t.left);
            }
        }
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        TreeNode t = InputHelper.argsToTreeNode(args);
        ConstructStringFromBinaryTree o = new ConstructStringFromBinaryTree();
        System.out.println(o.tree2strV1(t));
    }
}
