package StringProblems;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuffer buffer = new StringBuffer();
        int count = 0;
        for (char c : S.toCharArray()) {
            if ((c == '(' && count++ != 0) || (c == ')' && --count != 0)) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses o = new RemoveOutermostParentheses();
        System.out.println("Result String: " + o.removeOuterParentheses("(()())(())(()(()))"));
    }
}