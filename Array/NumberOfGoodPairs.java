package Array;

import java.util.HashMap;
import java.util.Map;

import Util.InputHelper;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] map = new int[101];
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            count += map[nums[i]]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        NumberOfGoodPairs o = new NumberOfGoodPairs();
        System.out.println("Number of Good Pairs: " + o.numIdenticalPairs(input));
    }
}