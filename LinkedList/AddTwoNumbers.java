package LinkedList;

import CommonDS.ListNode;
import Util.InputHelper;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        addNodes(l1, l2, resultNode, 0);
        return resultNode;
    }

    private boolean addNodes(ListNode l1, ListNode l2, ListNode resultNode, int carry) {
        if (l1 == null && l2 == null) {
            if (carry > 0) {
                resultNode.val = carry;
                return true;
            } else {
                resultNode = null;
                return false;
            }
        }
        int val = carry;
        val += l1 != null ? l1.val : 0;
        val += l2 != null ? l2.val : 0;
        carry = val / 10;
        val = val % 10;
        resultNode.val = val;
        resultNode.next = new ListNode();
        boolean nodeAdded = addNodes(l1 == null ? l1 : l1.next, l2 == null ? l2 : l2.next, resultNode.next, carry);
        if (!nodeAdded) {
            resultNode.next = null;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = InputHelper.argsToLisNode(args);
        ListNode l2 = InputHelper.argsToLisNode(args, 1);
        AddTwoNumbers o = new AddTwoNumbers();
        ListNode output = o.addTwoNumbers(l1, l2);
        System.out.println(output);
    }

}