package StringProblems;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int max = 1;
        int iter = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                iter++;
            } else {
                iter = 1;
            }
            if (iter > max) {
                max = iter;
            }
        }
        return max;
    }
}
