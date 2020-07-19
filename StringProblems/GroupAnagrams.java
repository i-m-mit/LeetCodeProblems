package StringProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.ListToString;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String res;
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            res = new String(arr);
            if (!map.containsKey(res)) {
                map.put(res, new ArrayList<>());
            }
            map.get(res).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            return;
        }
        GroupAnagrams o = new GroupAnagrams();
        System.out.println(ListToString.convert2DListToString(o.groupAnagrams(args)));
    }
}