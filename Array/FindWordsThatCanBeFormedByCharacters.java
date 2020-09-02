package Array;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] master = new int[26];
        for (char c : chars.toCharArray()) {
            master[c - 'a']++;
        }

        int[] iter;
        boolean wordFound;
        int masterCount = 0;
        int iterCount;
        for (String word : words) {
            iter = new int[26];
            for (char c : word.toCharArray()) {
                iter[c - 'a']++;
            }
            wordFound = true;
            iterCount = 0;
            for (int i = 0; i < iter.length; i++) {
                if (iter[i] <= master[i]) {
                    iterCount += iter[i];
                } else {
                    wordFound = false;
                    break;
                }
            }

            if (wordFound) {
                masterCount += iterCount;
            }
        }

        return masterCount;
    }

    public int countCharactersV1(String[] words, String chars) {

        Map<Character, Integer> master = new HashMap<>();
        for (char c : chars.toCharArray()) {
            master.put(c, master.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> iter;
        boolean wordFound;
        int masterCount = 0;
        int iterCount;
        for (String word : words) {
            iter = new HashMap<>();
            for (char c : word.toCharArray()) {
                iter.put(c, iter.getOrDefault(c, 0) + 1);
            }
            wordFound = true;
            iterCount = 0;
            for (Character c : iter.keySet()) {
                if (master.containsKey(c) && master.get(c) >= iter.get(c)) {
                    iterCount += iter.get(c);
                } else {
                    wordFound = false;
                    break;
                }
            }
            if (wordFound) {
                masterCount += iterCount;
            }
        }

        return masterCount;
    }
}