package LinkedList;

import CommonDS.ListNode;
import Util.InputHelper;

public class ConvertBinaryNumberToInteger {
    int sum = 0;

    public int getDecimalValue(ListNode head) {
        if (head != null) {
            if (sum != 0) {
                sum = sum << 1;
            }
            sum = sum | head.val;
            getDecimalValue(head.next);
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = InputHelper.argsToLisNode(args);
        ConvertBinaryNumberToInteger o = new ConvertBinaryNumberToInteger();
        System.out.println("Sum: " + o.getDecimalValue(head));
    }
}