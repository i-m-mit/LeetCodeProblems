package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class NumbersSmallerThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] retArray = new int[nums.length];
        for (int i = 0; i < retArray.length; i++) {
            if (nums[i] == 0) {
                retArray[i] = 0;
            } else {
                retArray[i] = count[nums[i] - 1];
            }
        }
        return retArray;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        NumbersSmallerThanCurrent o = new NumbersSmallerThanCurrent();
        System.out.println("Output: " + ArrayToString.convert1DArrayToString(o.smallerNumbersThanCurrent(input)));
    }
}