package Sorting;

import Util.ArrayToString;
import Util.InputHelper;

public class SortColors {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0 && i > zeroIndex) {
                nums[i] = nums[zeroIndex];
                nums[zeroIndex++] = 0;
            } else if (nums[i] == 2 && i < twoIndex) {
                nums[i] = nums[twoIndex];
                nums[twoIndex--] = 2;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        SortColors o = new SortColors();
        o.sortColors(input);
        System.out.println(ArrayToString.convert1DArrayToString(input));
    }
}