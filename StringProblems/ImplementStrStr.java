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

    public static void main(String[] args) {
        ImplementStrStr o = new ImplementStrStr();
        System.out.println(o.strStrV1("mississippi", "pi"));
    }
}