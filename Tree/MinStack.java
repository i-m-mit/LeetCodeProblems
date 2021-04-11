package Tree;

import java.util.ArrayList;

public class MinStack {
    private int[] stack;
    private int top;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.top = -1;
        this.stack = new int[2];
        this.min = 0;
    }

    public void push(int x) {
        increaseeStack();
        stack[++top] = x;
        if (x < stack[min]) {
            this.min = top;
        }
    }

    public void pop() {
        if (top == -1) {
            throw new UnsupportedOperationException();
        }
        top--;
        decreseStack();
        findMin();
    }

    public int top() {
        if (top == -1) {
            throw new UnsupportedOperationException();
        }
        return stack[top];
    }

    public int getMin() {
        if (top == -1) {
            throw new UnsupportedOperationException();
        }
        return stack[min];
    }

    private void findMin() {
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i <= top; i++) {
            if (stack[i] <= minVal) {
                this.min = i;
                minVal = stack[i];
            }
        }
    }

    private void increaseeStack() {
        if (this.top == this.stack.length - 1) {
            int[] tempArr = new int[this.stack.length * 2];
            int idx = 0;
            for (int num : this.stack) {
                tempArr[idx++] = num;
            }
            this.stack = tempArr;
        }
    }

    private void decreseStack() {
        if (this.top == this.stack.length / 4) {
            int[] tempArr = new int[this.stack.length / 2];
            for (int i = 0; i <= top; i++) {
                tempArr[i] = stack[i];
            }
            this.stack = tempArr;
        }
    }

    class Node {
        int val, min;
        Node next;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
            this.next = null;
        }
    }

    Node head;

    public void pushV1(int x) {
        Node l1;
        if (head == null) {
            l1 = new Node(x, x);
        } else {
            l1 = new Node(x, Math.min(x, head.min));
            l1.next = head;
        }
        head = l1;
    }

    public void popV1() {
        if (head != null) {
            head = head.next;
        }
    }

    public int topV1() {
        if (head == null) {
            return -1;
        }
        return head.val;
    }

    public int getMinV1() {
        if (head == null) {
            return -1;
        }
        return head.min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        ArrayList<Integer> list = new ArrayList<>();
        stack.push(2147483646);
        stack.push(2147483646);
        stack.push(2147483647);
        list.add(stack.top());
        stack.pop();
        list.add(stack.getMin());
        stack.pop();
        list.add(stack.getMin());
        stack.pop();
        stack.push(2147483647);
        list.add(stack.top());
        list.add(stack.getMin());
        stack.push(-2147483648);
        list.add(stack.top());
        list.add(stack.getMin());
        stack.pop();
        list.add(stack.getMin());
        System.out.println(list.toString());
        System.out.println(
                "[2147483647, 2147483646, 2147483646, 2147483647, 2147483647, -2147483648, -2147483648, 2147483647]");
        // [2147483647,2147483646,2147483646,2147483647,2147483647,-2147483648,-2147483648,2147483647]
    }
}
