package Array;

import Util.InputHelper;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minVal = Math.min(minVal, sum);
        }
        return Math.max(1 - minVal, 1);
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        MinimumValueToGetPositiveStepByStepSum o = new MinimumValueToGetPositiveStepByStepSum();
        System.out.println(o.minStartValue(nums));
    }
}
