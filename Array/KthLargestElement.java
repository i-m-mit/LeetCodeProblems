package Array;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

import Util.InputHelper;

public class KthLargestElement {
    // Sorting
    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = new int[nums.length];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = nums[i];
        }
        Arrays.sort(sortedArray);
        return sortedArray[sortedArray.length - k];
    }

    // Heap
    public int findKthLargestV1(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        int k = Integer.parseInt(args[1]);
        KthLargestElement o = new KthLargestElement();
        System.out.println(k + "th largest Element : " + o.findKthLargestV1(input, k));
    }
}