package StringProblems;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer out = new StringBuffer();
        int n = Integer.MAX_VALUE;
        for (String string : strs) {
            n = Math.min(n, string.length());
        }
        char c;
        boolean match;
        for (int i = 0; i < n; i++) {
            c = strs[0].charAt(i);
            match = true;
            for (int j = 1; j < strs.length && match; j++) {
                match &= c == strs[j].charAt(i);
            }
            if (match) {
                out.append(c);
            } else {
                break;
            }
        }
        return out.toString();
    }

    // Horizontal Scanning
    public String longestCommonPrefixV1(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }

    // Vertical Scanning
    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();
        System.out.println("Longest prefix: " + o.longestCommonPrefixV1(args));
    }
}