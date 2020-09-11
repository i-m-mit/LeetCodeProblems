package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int ro = nums.length;
        if (ro == 0) {
            return nums;
        }
        int co = nums[0].length;
        if (ro * co != r * c) {
            return nums;
        }
        int[][] ret = new int[r][c];
        int iterRow = 0;
        int iterCol = 0;
        for (int i = 0; i < ro; i++) {
            for (int j = 0; j < co; j++) {
                ret[iterRow][iterCol++] = nums[i][j];
                if (iterCol >= c) {
                    iterRow++;
                    iterCol = 0;
                }
            }
        }
        return ret;
    }

    public int[][] matrixReshapeV1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length)
            return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                res[count / c][count % c] = nums[i][j];
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = InputHelper.stringTo2DIntegerArray(args);
        ReshapeTheMatrix o = new ReshapeTheMatrix();

        System.out.println(ArrayToString.convert2DArrayToString(o.matrixReshape(nums, 1, 4)));
    }
}
