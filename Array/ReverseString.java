package Array;

import Util.ArrayToString;

public class ReverseString {
    // Approach 1
    public void reverseString(char[] s) {
        char swap;
        int n = s.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            swap = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = swap;
        }
    }

    // Approach 2
    public void reverseStringV1(char[] s) {
        char swap;
        int left = 0, right = s.length - 1;
        while (left < right) {
            swap = s[left];
            s[left++] = s[right];
            s[right--] = swap;
        }
    }

    public static void main(String[] args) {
        char[] array = new char[] { 'h', 'e', 'l', 'l', 'o' };
        ReverseString o = new ReverseString();
        o.reverseString(array);
        System.out.println("Reversed String: " + ArrayToString.convert1DArrayToString(array));
    }
}