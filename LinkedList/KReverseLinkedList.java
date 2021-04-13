package LinkedList;

import CommonDS.ListNode;
import Util.InputHelper;

/**
 * KReverseLinkedList
 */
public class KReverseLinkedList {
    public ListNode reverseList(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        int count = 0;
        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null)
            head.next = reverseList(next, k);

        // prev is now head of input list
        return prev;
    }

    public static void main(String[] args) {
        ListNode A = InputHelper.argsToLisNode(args);
        KReverseLinkedList o = new KReverseLinkedList();
        ListNode r = o.reverseList(A, 3);
        System.out.println(r);
    }

}