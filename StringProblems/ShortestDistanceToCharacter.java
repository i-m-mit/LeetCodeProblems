package StringProblems;

import java.util.Arrays;
import java.util.TreeSet;

public class ShortestDistanceToCharacter {
    public int[] shortestToChar(String S, char C) {
        int[] ret = new int[S.length()];
        char[] charArray = S.toCharArray();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = findShortest(charArray, i, C);
        }
        return ret;
    }

    private int findShortest(char[] charArray, int index, char c) {
        if (charArray[index] == c) {
            return 0;
        }
        int i = index, j = index;
        while (true) {
            if (i < 0 && j >= charArray.length) {
                break;
            }
            i--;
            j++;
            if (i >= 0 && charArray[i] == c) {
                return Math.abs(i - index);
            } else if (j < charArray.length && charArray[j] == c) {
                return Math.abs(j - index);
            }
        }
        return -1;
    }

    public int[] shortestToCharV1(String S, char C) {
        TreeSet<Integer> set = new TreeSet<>();

        // add all indexes of C into tree set
        for (int i = 0; i < S.length(); i++)
            if (S.charAt(i) == C)
                set.add(i);

        int[] result = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            if (!set.contains(i)) {

                Integer left = set.floor(i);
                Integer right = set.ceiling(i);

                if (left == null)
                    left = Integer.MAX_VALUE;
                if (right == null)
                    right = Integer.MAX_VALUE;

                result[i] = Math.min(Math.abs(left - i), Math.abs(right - i));

            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public int[] shortestToCharV2(String S, char C) {
        int N = S.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == C)
                prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; --i) {
            if (S.charAt(i) == C)
                prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }

        return ans;
    }

    public static void main(String[] args) {
        ShortestDistanceToCharacter o = new ShortestDistanceToCharacter();
        System.out.println("Shorted distances: " + Arrays.toString(o.shortestToCharV2("loveleetcode", 'e')));
    }
}
