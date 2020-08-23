package StringProblems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    String[] chars = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
            "--.." };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        StringBuffer buffer;
        for (String string : words) {
            buffer = new StringBuffer();
            for (char c : string.toCharArray()) {
                buffer.append(chars[c - 'a']);
            }
            set.add(buffer.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {

    }
}