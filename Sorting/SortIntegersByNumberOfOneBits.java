package Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

import Util.InputHelper;

public class SortIntegersByNumberOfOneBits {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
        return arr;
    }

    private void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, end, mid);
    }

    private void merge(int[] arr, int start, int end, int mid) {
        int i, j, k;
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] l1 = new int[n1];
        int[] l2 = new int[n2];
        for (i = 0; i < n1; i++) {
            l1[i] = arr[start + i];
        }
        for (j = 0; j < n2; j++) {
            l2[j] = arr[mid + 1 + j];
        }

        int leftBit, rightBit;

        i = 0;
        j = 0;
        k = start;
        while (i < n1 && j < n2) {
            leftBit = Integer.bitCount(l1[i]);
            rightBit = Integer.bitCount(l2[j]);

            if (leftBit < rightBit) {
                arr[k++] = l1[i++];
            } else if (leftBit > rightBit) {
                arr[k++] = l2[j++];
            } else {
                if (l1[i] <= l2[j]) {
                    arr[k++] = l1[i++];
                } else {
                    arr[k++] = l2[j++];
                }
            }
        }

        while (i < n1) {
            arr[k++] = l1[i++];
        }

        while (j < n2) {
            arr[k++] = l2[j++];
        }
    }

    public int[] sortByBitsV1(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < arr.length; i++) {
            int count = calcualte1Bit(arr[i]);
            pq.offer(new int[] { count, arr[i] });
        }
        int[] result = new int[arr.length];
        int index = 0;
        while (!pq.isEmpty())
            result[index++] = pq.poll()[1];

        return result;
    }

    private int calcualte1Bit(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = InputHelper.stringToIntegers(args);
        SortIntegersByNumberOfOneBits o = new SortIntegersByNumberOfOneBits();

        System.out.println("Sorted Array: " + Arrays.toString(o.sortByBitsV1(arr)));
    }
}