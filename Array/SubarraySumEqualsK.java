package Array;

import java.util.HashMap;

import Util.InputHelper;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
            if (sums[i] == k) {
                count++;
            }
        }
        return count;
    }

    public int subarraySumV1(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        int k = Integer.parseInt(args[1]);
        SubarraySumEqualsK o = new SubarraySumEqualsK();
        System.out.println("Number of subarrays: " + o.subarraySumV1(nums, k));
    }
}