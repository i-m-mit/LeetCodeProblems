package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.InputHelper;

public class IntersectionOfTwoArraysII {
    // Sort Approach
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersection = new ArrayList<>();
        int j = 0, k = 0;
        while (j < nums1.length && k < nums2.length) {
            if (nums1[j] == nums2[k]) {
                intersection.add(nums1[j]);
                j++;
                k++;
            } else if (nums1[j] > nums2[k]) {
                k++;
            } else {
                j++;
            }
        }
        return intersection.stream().mapToInt(i -> i).toArray();
    }

    // Hash Map Approach
    public int[] intersectV1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> intersection = new ArrayList<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                intersection.add(i);
                map.put(i, map.get(i) - 1);
            }
        }

        return intersection.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = InputHelper.stringToIntegers(args);
        int[] nums2 = InputHelper.stringToIntegers(args, 1);
        IntersectionOfTwoArraysII o = new IntersectionOfTwoArraysII();

        System.out.println("Intersacting Array: " + Arrays.toString(o.intersectV1(nums1, nums2)));
    }
}