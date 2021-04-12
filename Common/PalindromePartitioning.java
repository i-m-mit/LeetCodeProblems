package Common;

import java.util.ArrayList;

/**
 * PalindromePartitioning
 */
public class PalindromePartitioning {
    ArrayList<ArrayList<String>> result;

    public ArrayList<ArrayList<String>> partition(String a) {
        result = new ArrayList<>();
        iterate(0, a.toCharArray(), new ArrayList<>());
        return result;
    }

    private void iterate(int start, char[] str, ArrayList<String> cur) {
        if (start == str.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        StringBuffer buffer = new StringBuffer();
        for (int i = start; i < str.length; i++) {
            buffer.append(str[i]);
            if (isPalindrome(buffer.toString())) {
                cur.add(buffer.toString());
                iterate(i + 1, str, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}