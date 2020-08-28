package Array;

import java.util.Arrays;

import Util.InputHelper;

public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int even = 0;
        int odd = 1;
        int[] retArray = new int[A.length];
        for (int i = 0; i < retArray.length; i++) {
            if (A[i] % 2 == 0) {
                retArray[even] = A[i];
                even += 2;
            } else {
                retArray[odd] = A[i];
                odd += 2;
            }
        }
        return retArray;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        SortArrayByParityII o = new SortArrayByParityII();
        System.out.println("Sorted Array: " + Arrays.toString(o.sortArrayByParityII(A)));
    }
}