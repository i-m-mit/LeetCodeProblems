package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Util.InputHelper;

public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] ret = new int[arr.length];
        int[] clone = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        int iter = 1;
        for (int i = 0; i < clone.length; i++) {
            if (!map.containsKey(clone[i])) {
                map.put(clone[i], iter++);
            }
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i] = map.get(arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.stringToIntegers(args);
        RankTransformOfArray o = new RankTransformOfArray();

        System.out.println(Arrays.toString(o.arrayRankTransform(arr)));
    }
}
