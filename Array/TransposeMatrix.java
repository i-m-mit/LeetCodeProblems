package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ret = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[j][i] = A[i][j];
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] A = InputHelper.stringTo2DIntegerArray(args);
        TransposeMatrix o = new TransposeMatrix();

        System.out.println("Transposed Matrix: " + ArrayToString.convert2DArrayToString(o.transpose(A)));
    }
}
