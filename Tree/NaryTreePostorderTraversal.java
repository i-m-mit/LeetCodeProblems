package Tree;

import java.util.ArrayList;
import java.util.List;

import CommonDS.NaryTreeNode;
import Util.InputHelper;
import Util.ListToString;

public class NaryTreePostorderTraversal {
    List<Integer> ret = new ArrayList<>();

    public List<Integer> postorder(NaryTreeNode root) {
        if (root == null) {
            return ret;
        }
        for (NaryTreeNode node : root.children) {
            postorder(node);
        }
        ret.add(root.val);
        return ret;
    }

    public static void main(String[] args) {
        NaryTreeNode root = InputHelper.argsToNaryTreeNode(args);
        NaryTreePostorderTraversal o = new NaryTreePostorderTraversal();
        System.out.println("Postorder: " + ListToString.convertListToString(o.postorder(root)));
    }
}