package Common;

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean bRet = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        bRet = false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')
                        bRet = false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[')
                        bRet = false;
                    break;
                default:
                    stack.push(c);
                    break;
            }
            if (!bRet)
                break;
        }
        return bRet && stack.empty();
    }

    public static void main(String[] args) {
        ValidParantheses o = new ValidParantheses();

        System.out.println(o.isValid("()"));
    }
}