package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Util.InputHelper;
import Util.ListToString;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        if (arr.length < 2) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(arr);
        int minVal = Integer.MAX_VALUE;
        int cur;
        for (int i = 0; i < arr.length - 1; i++) {
            cur = arr[i + 1] - arr[i];
            if (cur < minVal) {
                minVal = cur;
            }
        }
        List<Integer> iter;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minVal) {
                iter = new ArrayList<>();
                iter.add(arr[i]);
                iter.add(arr[i + 1]);
                ret.add(iter);
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.stringToIntegers(args);
        MinimumAbsoluteDifference o = new MinimumAbsoluteDifference();

        System.out.println("Return List: " + ListToString.convertListToString(o.minimumAbsDifference(arr)));
    }
}
