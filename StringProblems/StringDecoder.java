package StringProblems;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StringDecoder {

    // #region Stack Approach

    public String decodeString(String s) {
        Stack<Object> stack = new Stack<>();
        StringBuffer buffer = new StringBuffer();
        int repeat = 0;
        String top;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(repeat);
                stack.push(buffer.toString());
                buffer = new StringBuffer();
                repeat = 0;
            } else if (c == ']') {
                top = stack.pop().toString();
                int num = Integer.parseInt(stack.pop().toString());
                buffer = new StringBuffer(top + buffer.toString().repeat(num));
            } else if (Character.isDigit(c)) {
                repeat = repeat * 10 + Integer.parseInt(c + "");
            } else {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    // #endregion

    // #region Recursive Approch using Queue

    public String decodeStringV1(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray())
            queue.offer(c);
        return helper(queue);
    }

    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++)
                    sb.append(sub);
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // #endregion

    // #region Recursive Approach O(0) Time complexity

    int i;

    public String decodeStringV2(String s) {
        i = 0;
        return decode(s.toCharArray());
    }

    public String decode(char[] arr) {
        StringBuffer ret = new StringBuffer();

        while (i < arr.length && arr[i] != ']') {
            if (!Character.isDigit(arr[i])) {
                ret.append(arr[i++]);
            } else {
                int n = 0;
                while (i < arr.length && Character.isDigit(arr[i])) {
                    n = n * 10 + arr[i++] - '0';
                }

                i++;
                ret.append(decode(arr).repeat(n));
                i++;
            }
        }

        return ret.toString();
    }

    // #endregion

    public static void main(String[] args) {
        String input = args[0];
        StringDecoder o = new StringDecoder();
        System.out.println("Encoded: " + input + "\nDecoded: " + o.decodeStringV2(input));
    }
}