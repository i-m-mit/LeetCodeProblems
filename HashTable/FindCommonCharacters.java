package HashTable;

import java.util.ArrayList;
import java.util.List;

import Util.ListToString;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        int[] map = new int[26];
        int[] iterMap;
        for (char c : A[0].toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            iterMap = new int[26];
            for (char c : A[i].toCharArray()) {
                iterMap[c - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                map[j] = Math.min(map[j], iterMap[j]);
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                for (int j = 0; j < map[i]; j++) {
                    ret.add(((char) (i + 'a')) + "");
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        FindCommonCharacters o = new FindCommonCharacters();
        System.out.println(ListToString.convertListToString(o.commonChars(args)));
    }
}