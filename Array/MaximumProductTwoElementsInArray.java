package Array;

import java.util.Arrays;

import Util.InputHelper;

public class MaximumProductTwoElementsInArray {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        return (nums[n] - 1) * (nums[n - 1] - 1);
    }

    public int maxProductV1(int[] nums) {
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i >= max) {
                smax = max;
                max = i;
            } else if (i > smax) {
                smax = i;
            }
        }
        return (max - 1) * (smax - 1);
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        MaximumProductTwoElementsInArray o = new MaximumProductTwoElementsInArray();
        System.out.println("Max product: " + o.maxProductV1(nums));
    }
}