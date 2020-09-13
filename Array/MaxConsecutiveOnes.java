package Array;

import Util.InputHelper;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                cur++;
                if (cur > max) {
                    max = cur;
                }
            } else {
                cur = 0;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        MaxConsecutiveOnes o = new MaxConsecutiveOnes();

        System.out.println(o.findMaxConsecutiveOnes(nums));
    }
}