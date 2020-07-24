package DynamicProgramming;

import Util.InputHelper;

public class HouseRobberTwo {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n == 1 ? nums[0] : 0;
        }
        return Math.max(calculateMax(nums, 0, n - 2), calculateMax(nums, 1, n - 1));
    }

    private int calculateMax(int[] nums, int i, int j) {
        int prevRobbed = 0;
        int prevUnrobbed = 0;
        int currentRobbed;
        for (int iter = i; iter <= j; iter++) {
            currentRobbed = nums[iter] + prevUnrobbed;
            prevUnrobbed = Math.max(prevRobbed, prevUnrobbed);
            prevRobbed = currentRobbed;
        }
        return Math.max(prevRobbed, prevUnrobbed);
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        HouseRobberTwo o = new HouseRobberTwo();
        System.out.println("Maximum amount of money you can rob : " + o.rob(input));
    }
}