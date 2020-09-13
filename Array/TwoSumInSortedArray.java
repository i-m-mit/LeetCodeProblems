package Array;

import java.util.Arrays;

import Util.InputHelper;

public class TwoSumInSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        int sum;
        while (low < high) {
            sum = numbers[low] + numbers[high];
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                ret[0] = low + 1;
                ret[1] = high + 1;
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] numbers = InputHelper.stringToIntegers(args);
        TwoSumInSortedArray o = new TwoSumInSortedArray();
        System.out.println(Arrays.toString(o.twoSum(numbers, 9)));
    }
}
