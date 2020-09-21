package Queue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        shift(false);
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shift(true);
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        shift(true);
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    private void shift(boolean toPop) {
        if (toPop) {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        } else {
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.push(1);
        q.push(2);
        q.peek();
        q.pop();
        q.empty();
    }
}
