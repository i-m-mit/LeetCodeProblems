package StringProblems;

import Util.InputHelper;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        StringBuffer retString = new StringBuffer(s);
        int iter = 0;
        for (int i : indices) {
            retString.setCharAt(i, s.charAt(iter++));
        }
        return retString.toString();
    }

    public static void main(String[] args) {
        String s = args[0];
        int[] indices = InputHelper.stringToIntegers(args, 1);

        ShuffleString o = new ShuffleString();
        System.out.println("Shuffled String: " + o.restoreString(s, indices));
    }
}