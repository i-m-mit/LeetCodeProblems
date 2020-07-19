package SingleElementInSortedArray;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;
        int mid;
        int retVal = -1;

        while (low <= high) {
            mid = (high + low) / 2;
            if (high == low) {
                retVal = nums[low];
                break;
            }

            boolean isEvenSplit = (mid - low) % 2 == 0;

            if (nums[mid] == nums[mid - 1]) {
                if (isEvenSplit) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if (isEvenSplit) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            } else {
                retVal = nums[mid];
                break;
            }

        }
        return retVal;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = { 1, 1, 3, 3, 4, 4, 7, 8, 8 };
        System.out.println(sol.singleNonDuplicate(nums));
    }
}