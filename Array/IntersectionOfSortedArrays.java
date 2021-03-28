package Array;

import java.util.ArrayList;

import Util.ArrayToString;
import Util.InputHelper;

/**
 * IntersectionOfSortedArrays
 */
public class IntersectionOfSortedArrays {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] intersect(final int[] A, final int[] B) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (i < A.length && j < B.length) {
            if (A[i] == B[j]) {
                result.add(B[j++]);
                i++;
            } else if (A[i] < B[j])
                i++;
            else if (A[i] > B[j])
                j++;
        }
        if (result.size() == 0) {
            return new int[] {};
        }
        int[] ret = new int[result.size()];
        for (i = 0; i < ret.length; i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        int[] B = InputHelper.stringToIntegers(args, 1);
        IntersectionOfSortedArrays o = new IntersectionOfSortedArrays();
        System.out.println(ArrayToString.convert1DArrayToString(o.intersect(A, B)));
    }
}