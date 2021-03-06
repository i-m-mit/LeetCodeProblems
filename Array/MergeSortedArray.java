package Array;

import java.util.ArrayList;
import java.util.Arrays;

import Util.InputHelper;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = a.size() - 1;
        int j = b.size() - 1;
        while (i >= 0 && j >= 0) {
            if (a.get(i) <= b.get(j)) {
                a.add(i + 1, b.get(j));
                j--;
            } else {
                i--;
            }
        }
        while (j >= 0) {
            a.add(0, b.get(j--));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = InputHelper.stringToIntegers(args);
        int[] nums2 = InputHelper.stringToIntegers(args, 1);
        MergeSortedArray o = new MergeSortedArray();
        o.merge(nums1, 3, nums2, 3);
        System.out.println("Sorted Array: " + Arrays.toString(nums1));
    }
}