package Searching;

import Util.ArrayToString;
import Util.InputHelper;

/**
 * SearchForRange
 */
public class SearchForRange {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int lo = 0;
        int hi = A.length - 1;
        int mid = 0, val;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            val = A[mid];
            if (val > B) {
                hi = mid - 1;
            } else if (val < B) {
                lo = mid + 1;
            } else {
                if (mid == 0 || A[mid - 1] != B) {
                    result[0] = mid;
                    break;
                } else {
                    hi = mid - 1;
                }
            }
        }

        lo = mid;
        hi = A.length - 1;
        while (lo <= hi) {
            mid = (hi + lo) / 2;
            val = A[mid];
            if (val > B) {
                hi = mid - 1;
            } else if (val < B) {
                lo = mid + 1;
            } else {
                if (mid == A.length - 1 || A[mid + 1] != B) {
                    result[1] = mid;
                    break;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        SearchForRange o = new SearchForRange();
        System.out.println(ArrayToString.convert1DArrayToString(o.searchRange(A, 10)));
    }
}