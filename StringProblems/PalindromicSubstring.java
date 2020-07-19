package StringProblems;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstring {

    // Brute-Force Approach
    public int countSubstrings(String s) {
        if (s.length() <= 1)
            return s.length();
        List<String> list = new ArrayList<>();
        int count = 0;
        String subString;
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            list.clear();
            for (int i = charIndex + 1; i <= s.length(); i++) {
                subString = s.substring(charIndex, i);
                if (isPalindrom(subString)) {
                    list.add(subString);
                }
            }
            count += list.size();
        }
        return count;
    }

    private boolean isPalindrom(String s) {
        StringBuffer buffer = new StringBuffer(s);
        return s.equals(buffer.reverse().toString());
    }

    // Approach 2
    public int countSubstringsV1(String s) {
        int N = s.length(), ans = 0;
        for (int center = 0; center <= 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    // Manacher's Algorithm
    public int countSubstringsV2(String S) {
        char[] A = new char[2 * S.length() + 3];
        A[0] = '@';
        A[1] = '#';
        A[A.length - 1] = '$';
        int t = 2;
        for (char c : S.toCharArray()) {
            A[t++] = c;
            A[t++] = '#';
        }

        int[] Z = new int[A.length];
        int center = 0, right = 0;
        for (int i = 1; i < Z.length - 1; ++i) {
            if (i < right)
                Z[i] = Math.min(right - i, Z[2 * center - i]);
            while (A[i + Z[i] + 1] == A[i - Z[i] - 1])
                Z[i]++;
            if (i + Z[i] > right) {
                center = i;
                right = i + Z[i];
            }
        }
        int ans = 0;
        for (int v : Z)
            ans += (v + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        PalindromicSubstring o = new PalindromicSubstring();

        String i = "aaa";
        System.out.println("Total Palindromic Substring for '" + i + "' = " + o.countSubstringsV2(i));
    }
}