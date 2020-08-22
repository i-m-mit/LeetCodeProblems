package Array;

import java.util.Arrays;

import Util.InputHelper;

public class RotateArray {

    // Using Extra Array
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (k > n) {
            k -= n;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < res.length; i++) {
            nums[i] = res[i];
        }
    }

    // Using Cyclic Replacement
    public void rotateV1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    // Using Reverse
    public void rotateV2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        RotateArray o = new RotateArray();
        o.rotateV1(nums, 3);
        System.out.println("Rotated Array: " + Arrays.toString(nums));
    }
}