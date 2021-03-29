package BitManipulation;

import java.util.HashMap;

import Util.InputHelper;

public class SingleNumberII {// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    public int singleNumberV1(final int[] A) {
        if (A == null)
            return 0;
        int first = 0, second = 0;
        for (int i : A) {
            second = second | (first & i);
            first = first ^ i;
            int check = ~(first & second);
            first = first & check;
            second = second & check;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        SingleNumberII o = new SingleNumberII();
        System.out.println("Result: " + o.singleNumberV1(A));
    }

}