package StringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                ans.add(words[i + 2]);
            }
        }

        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        OccurrencesAfterBigram o = new OccurrencesAfterBigram();
        System.out
                .println(Arrays.toString(o.findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }
}
