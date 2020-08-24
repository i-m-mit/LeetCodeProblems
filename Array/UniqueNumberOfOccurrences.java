package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Util.InputHelper;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : map.values()) {
            if (!set.add(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.stringToIntegers(args);
        UniqueNumberOfOccurrences o = new UniqueNumberOfOccurrences();
        System.out.println(o.uniqueOccurrences(arr));
    }
}