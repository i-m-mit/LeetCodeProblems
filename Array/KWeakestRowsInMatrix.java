package Array;

import java.util.Arrays;
import java.util.PriorityQueue;

import Util.InputHelper;

public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count[i]++;
                } else {
                    break;
                }
            }
        }
        int[] ret = new int[k];
        int min;
        int idx;
        for (int i = 0; i < k; i++) {
            min = Integer.MAX_VALUE;
            idx = 0;
            for (int j = 0; j < count.length; j++) {
                if (min > count[j]) {
                    min = count[j];
                    idx = j;
                }
            }
            ret[i] = idx;
            count[idx] = Integer.MAX_VALUE;
        }
        return ret;
    }

    public int[] kWeakestRowsV1(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { numOnes(mat[i]), i });
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] mat = InputHelper.stringTo2DIntegerArray(args);
        KWeakestRowsInMatrix o = new KWeakestRowsInMatrix();
        System.out.println(Arrays.toString(o.kWeakestRowsV1(mat, 3)));
    }
}