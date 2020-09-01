package LinkedList;

import CommonDS.ListNode;
import Util.InputHelper;

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = InputHelper.argsToLisNode(args);
        MiddleOfLinkedList o = new MiddleOfLinkedList();

        System.out.println(o.middleNode(head).val);
    }
}