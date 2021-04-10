package LinkedList;

import java.util.HashSet;
import java.util.Stack;

import CommonDS.ListNode;
import Util.InputHelper;

/**
 * ReorderList
 */
public class ReorderList {

    public ListNode reorderList(ListNode A) {
        Stack<ListNode> reverse = new Stack<>();
        ListNode midPoint = findMidPoint(A);
        while (midPoint.next != null) {
            midPoint = midPoint.next;
            reverse.push(midPoint);
        }
        ListNode forward = A;
        ListNode swap;
        while (!reverse.isEmpty()) {
            swap = forward.next;
            forward.next = reverse.pop();
            forward.next.next = swap;
            forward = swap;
        }
        forward.next = null;
        return A;
    }

    private ListNode findMidPoint(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode A = InputHelper.argsToLisNode(args);
        ReorderList o = new ReorderList();
        ListNode ret = o.reorderList(A);
        System.out.println(ret);
    }
}