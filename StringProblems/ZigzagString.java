package StringProblems;

import java.util.ArrayList;

/**
 * ZigzagString
 */
public class ZigzagString {
    public String convert(String A, int B) {
        if (B == 1 || B > A.length())
            return A;
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            list.add(new ArrayList<>());
        }
        boolean inc = true;
        int i = 0;
        for (char c : A.toCharArray()) {
            list.get(i).add(c);
            i += inc ? 1 : -1;
            if (i == B) {
                inc = false;
                i = B - 2;
            }
            if (i == -1) {
                inc = true;
                i = 1;
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (ArrayList<Character> l : list) {
            for (char c : l) {
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        ZigzagString o = new ZigzagString();
        System.out.println(o.convert("PAYPALISHIRING", 3));
    }
}