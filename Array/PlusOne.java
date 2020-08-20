package Array;

import java.util.Arrays;

import Util.InputHelper;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        digits[n]++;
        digits[n] %= 10;
        while (n > 0 && digits[n] == 0) {
            digits[--n]++;
            digits[n] %= 10;
        }
        if (digits[0] == 0) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            n = 1;
            for (int i : digits) {
                ret[n++] = i;
            }
            return ret;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = InputHelper.stringToIntegers(args);
        PlusOne o = new PlusOne();
        System.out.println(Arrays.toString(o.plusOne(digits)));
    }
}