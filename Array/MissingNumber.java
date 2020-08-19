package Array;

import Util.InputHelper;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int i;
        for (i = 0; i < nums.length; i++) {
            sum += nums[i] - i;
        }

        return i - sum;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        MissingNumber o = new MissingNumber();
        System.out.println("Missing Number: " + o.missingNumber(input));
    }
}