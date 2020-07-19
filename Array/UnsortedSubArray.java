package Array;

public class UnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        boolean startFlag = false;
        boolean endFlag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (!startFlag) {
                    start = i;
                    startFlag = !startFlag;
                }
                endFlag = false;
            } else {
                if (!endFlag) {
                    end = i;
                    endFlag = !endFlag;
                }
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        UnsortedSubArray o = new UnsortedSubArray();
        System.out.println(o.findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
    }

}