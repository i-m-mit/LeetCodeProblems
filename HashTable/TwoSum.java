package HashTable;

import java.util.ArrayList;
import java.util.HashMap;

import Util.ArrayToString;
import Util.InputHelper;

/**
 * TwoSum
 */
public class TwoSum {

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] A, int B) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int key = B - A[i];
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(i);
        }
        int index1 = Integer.MAX_VALUE;
        int index2 = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int i1 = Math.min(map.get(A[i]).get(0), i);
                int i2 = Math.max(map.get(A[i]).get(0), i);
                if (i1 != i2) {
                    if (i2 < index2 || (i2 == index2 && i1 < index1)) {
                        index2 = i2;
                        index1 = i1;
                    }
                }
            }
        }

        return new int[] { index1 + 1, index2 + 1 };
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        TwoSum o = new TwoSum();
        System.out.println(ArrayToString.convert1DArrayToString(o.twoSum(A, -3)));
    }
}