package Math;

import java.util.Arrays;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        int i = 0;
        int d = S.length();
        int[] ret = new int[d + 1];
        int iter = 0;
        for (char c : S.toCharArray()) {
            ret[iter++] = c == 'I' ? i++ : d--;
        }
        ret[iter] = i;
        return ret;
    }

    public static void main(String[] args) {
        DIStringMatch o = new DIStringMatch();
        System.out.println("Result Array: " + Arrays.toString(o.diStringMatch("IDID")));
    }
}