package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import Util.InputHelper;

public class FindDuplicate {
    // Brute-force
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (i != j && nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    // Sorting Approach
    public int findDuplicateV1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    // Set Approach
    public int findDuplicateV2(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }

    // Floyd's Tortoise and Hare (Cycle Detection) Approach
    public int findDuplicateV3(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        FindDuplicate o = new FindDuplicate();
        System.out.println(o.findDuplicate(input));
    }
}