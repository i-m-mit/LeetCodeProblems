package StringProblems;

public class SplitStringInBalancedStrings {
    public int balancedStringSplit(String s) {
        int countR = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            countR += c == 'R' ? 1 : -1;
            if (countR == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        SplitStringInBalancedStrings o = new SplitStringInBalancedStrings();

        System.out.println("Number of balanced strings: " + o.balancedStringSplit(s));
    }
}