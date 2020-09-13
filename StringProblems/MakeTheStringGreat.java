package StringProblems;

import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && (c ^ 32) == stack.peek())
                stack.pop();
            else
                stack.push(c);
        }
        char[] arr = new char[stack.size()];
        int index = arr.length - 1;
        while (!stack.isEmpty()) {
            arr[index--] = stack.pop();
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        MakeTheStringGreat o = new MakeTheStringGreat();
        System.out.println(o.makeGood("abBAcC"));
    }
}
