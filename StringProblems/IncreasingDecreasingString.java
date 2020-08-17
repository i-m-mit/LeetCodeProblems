package StringProblems;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        boolean reverse = false;
        int i = 0;
        StringBuffer buffer = new StringBuffer();
        while (buffer.length() < s.length()) {
            for (int j = 0; j < map.length; j++) {
                i = reverse ? 25 - j : j;
                if (map[i] != 0) {
                    buffer.append((char) (i + 'a'));
                    map[i]--;
                }
            }
            reverse = !reverse;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = args[0];
        IncreasingDecreasingString o = new IncreasingDecreasingString();

        System.out.println("Sorted String: " + o.sortString(s));
    }
}