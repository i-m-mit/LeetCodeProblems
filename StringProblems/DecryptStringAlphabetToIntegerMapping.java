package StringProblems;

public class DecryptStringAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        if (s == null || s == "") {
            return "";
        }

        int toPush;
        StringBuffer buffer = new StringBuffer();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '#') {
                toPush = Integer.parseInt(s.substring(i - 2, i));
                i -= 2;
            } else {
                toPush = Integer.parseInt(c + "");
            }
            buffer.insert(0, (char) (toPush + 96));
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "10#11#12";
        DecryptStringAlphabetToIntegerMapping o = new DecryptStringAlphabetToIntegerMapping();

        System.out.println("Decrypted String : " + o.freqAlphabets(s));
    }
}