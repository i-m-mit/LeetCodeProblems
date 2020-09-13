package StringProblems;

import java.util.Stack;

public class ReformatTheString {
    public String reformat(String s) {
        Stack<Character> letter = new Stack<>();
        Stack<Character> digit = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letter.push(c);
            } else {
                digit.push(c);
            }
        }
        int sizeL = letter.size();
        int sizeD = digit.size();
        if (Math.abs(sizeL - sizeD) > 1) {
            return "";
        }
        StringBuffer buffer = new StringBuffer();
        if (sizeL > sizeD) {
            buffer.insert(0, letter.pop());
            while (!letter.isEmpty()) {
                buffer.insert(0, digit.pop());
                buffer.insert(0, letter.pop());
            }
        } else {
            if (sizeL != sizeD) {
                buffer.insert(0, digit.pop());
            }
            while (!digit.isEmpty()) {
                buffer.insert(0, letter.pop());
                buffer.insert(0, digit.pop());
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        ReformatTheString o = new ReformatTheString();
        System.out.println(o.reformat("ab123"));
    }
}
