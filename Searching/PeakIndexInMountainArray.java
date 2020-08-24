package Searching;

import Util.InputHelper;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int low = 0;
        int high = A.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] < A[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        PeakIndexInMountainArray o = new PeakIndexInMountainArray();
        System.out.println(o.peakIndexInMountainArray(A));
    }
}