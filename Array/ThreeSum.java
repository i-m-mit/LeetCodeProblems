package Array;

import java.util.Arrays;

/**
 * ThreeSum
 */
public class ThreeSum {

    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int targetSum;
        int minDistance = Integer.MAX_VALUE;
        int sum;
        int j, k;
        int n = A.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            targetSum = B - A[i];
            j = i == 0 ? 1 : 0;
            k = i == n - 1 ? n - 2 : n - 1;
            while (j < k) {
                sum = A[j] + A[k];
                if (Math.abs(sum - targetSum) < minDistance) {
                    ans = sum - targetSum + B;
                    minDistance = Math.abs(sum - targetSum);
                }
                if (sum > targetSum) {
                    k--;
                } else if (sum < targetSum) {
                    j++;
                }
                if (k == i) {
                    k--;
                }
                if (j == i) {
                    j++;
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {

    }
}