package CommonDS;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(Integer[] nodes) {
        if (nodes.length == 0)
            return null;
        ListNode head = new ListNode(nodes[0]);
        ListNode curreNode = head;
        for (int i = 1; i < nodes.length; i++) {
            curreNode.next = new ListNode(nodes[i]);
            curreNode = curreNode.next;
        }
        return head;
    }
}