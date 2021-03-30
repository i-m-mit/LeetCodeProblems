package StringProblems;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int n = needle.length();
        String cur;
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            cur = haystack.substring(i, i + n);
            if (cur.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStrV1(String haystack, String needle) {
        for (int i = 0;; i++) {
            for (int j = 0;; j++) {
                if (j == needle.length())
                    return i;
                if (i + j == haystack.length())
                    return -1;
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break;
            }
        }
    }

    public int strStrV2(String A, String B) {
        int lenB = B.length();
        int[] prefixSuffixArray = new int[lenB];
        int i = 0;
        int j = 1;
        while (j < lenB) {
            if (B.charAt(i) == B.charAt(j)) {
                prefixSuffixArray[j++] = ++i;
            } else {
                if (i != 0) {
                    i = prefixSuffixArray[i - 1];
                } else {
                    prefixSuffixArray[j++] = 0;
                }
            }
        }

        i = 0;
        j = 0;
        while (i < lenB && j < A.length()) {
            if (B.charAt(i) == A.charAt(j)) {
                i++;
                j++;
            } else {
                if (i != 0) {
                    i = prefixSuffixArray[i - 1];
                } else {
                    j++;
                }
            }
        }

        return i == lenB ? j - lenB : -1;
    }

    public static void main(String[] args) {
        ImplementStrStr o = new ImplementStrStr();
        System.out.println(o.strStrV2(
                "aabaaaababaabbbabbabbbaabababaaaaaababaaabbabbabbabbaaaabbbbbbaabbabbbbbabababbaaabbaabbbababbb",
                "bba"));
    }
}