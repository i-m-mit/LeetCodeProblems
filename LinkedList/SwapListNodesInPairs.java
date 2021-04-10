package LinkedList;

import CommonDS.ListNode;

/**
 * SwapListNodesInpairs
 */
public class SwapListNodesInPairs {
    public ListNode swapPairs(ListNode A) {
        return traverse(A, null);
    }

    private ListNode traverse(ListNode A, ListNode B) {
        if (A == null)
            return null;
        ListNode swap = A;
        if (A.next != null) {
            swap = A.next;
            A.next = A.next.next;
            swap.next = A;
            if (B != null) {
                B.next = swap;
            }
            traverse(A.next, A);
        }
        return swap;
    }
}