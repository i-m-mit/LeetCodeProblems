package Sorting;

import Util.ArrayToString;
import Util.InputHelper;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int odd = A.length - 1;
        int even = 0;
        int temp;
        while (even < odd) {
            if (A[even] % 2 != 0) {
                temp = A[odd];
                A[odd--] = A[even];
                A[even] = temp;
            } else {
                even++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        SortArrayByParity o = new SortArrayByParity();
        System.out.println("Sorted Array: " + ArrayToString.convert1DArrayToString(o.sortArrayByParity(input)));
    }
}