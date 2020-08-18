package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i += 2) {
            count += nums[i];
        }

        int[] retArray = new int[count];
        int j = 1;
        int k = 0;
        count = nums[k];
        for (int i = 0; i < retArray.length; i++) {
            if (count == 0) {
                k += 2;
                j += 2;
                count = nums[k];
            }
            retArray[i] = nums[j];
            count--;
        }
        return retArray;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        DecompressRunLengthEncodedList o = new DecompressRunLengthEncodedList();

        System.out.println(ArrayToString.convert1DArrayToString(o.decompressRLElist(input)));
    }
}