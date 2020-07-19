package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[] storage = new int[n * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                storage[k++] = matrix[i][j];
            }
        }
        k = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = storage[k++];
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = InputHelper.stringTo2DIntegerArray(args);
        RotateImage o = new RotateImage();
        o.rotate(input);
        System.out.println(ArrayToString.convert2DArrayToString(input));
    }
}