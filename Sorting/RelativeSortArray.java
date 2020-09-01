package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.InputHelper;

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : arr2) {
            map.put(i, new ArrayList<>());
        }
        map.put(-1, new ArrayList<>());
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.get(arr1[i]).add(i);
            } else {
                map.get(-1).add(i);
            }
        }
        int[] ret = new int[arr1.length];

        int i = 0;
        for (int index : arr2) {
            List<Integer> lst = map.get(index);
            for (int j : lst) {
                ret[i++] = arr1[j];
            }
        }
        List<Integer> lst = map.get(-1);
        lst.sort((a1, a2) -> arr1[a1] - arr1[a2]);
        for (int j : lst) {
            ret[i++] = arr1[j];
        }
        return ret;
    }

    public int[] relativeSortArrayV1(int[] arr1, int[] arr2) {
        int out[] = new int[arr1.length];
        int ind[] = new int[1001];

        // Get count of occurences in arr1
        for (int i = 0; i < arr1.length; i++) {
            ind[arr1[i]]++;
        }

        // Now based on arr2 order emit output
        int k = 0;
        for (int i = 0; i < arr2.length; i++) {
            int times = ind[arr2[i]];
            for (int j = 0; j < times; j++) {
                out[k++] = arr2[i];
            }
            ind[arr2[i]] = 0;
        }

        // Finally process those entries that aren't in arr2 but in arr1
        for (int i = 0; i < ind.length; i++) {
            int times = ind[i];
            for (int j = 0; j < times; j++) {
                out[k++] = i;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr1 = InputHelper.stringToIntegers(args);
        int[] arr2 = InputHelper.stringToIntegers(args, 1);
        RelativeSortArray o = new RelativeSortArray();

        System.out.println("Sorted Array: " + Arrays.toString(o.relativeSortArray(arr1, arr2)));
    }
}