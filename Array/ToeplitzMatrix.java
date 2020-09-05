package Array;

import Util.InputHelper;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int cur;
        int j, k;
        for (int i = 0; i < matrix[0].length; i++) {
            cur = matrix[0][i];
            j = 1;
            k = i + 1;
            while (j < matrix.length && k < matrix[j].length) {
                if (matrix[j++][k++] != cur) {
                    return false;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            cur = matrix[i][0];
            j = i + 1;
            k = 1;
            while (j < matrix.length && k < matrix[j].length) {
                if (matrix[j++][k++] != cur) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = InputHelper.stringTo2DIntegerArray(args);
        ToeplitzMatrix o = new ToeplitzMatrix();

        System.out.println(o.isToeplitzMatrix(matrix));
    }
}
