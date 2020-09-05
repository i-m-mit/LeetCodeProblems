package StringProblems;

import java.util.Arrays;

import Util.InputHelper;

public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        int[] ans = new int[2];
        ans[0] = 1;
        int cur;
        for (char c : S.toCharArray()) {
            cur = widths[c - 'a'];
            if (cur + ans[1] > 100) {
                ans[0]++;
                ans[1] = 0;
            }
            ans[1] += cur;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] widths = InputHelper.stringToIntegers(args);
        NumberOfLinesToWriteString o = new NumberOfLinesToWriteString();
        System.out.println(Arrays.toString(o.numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz")));
    }
}
