package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        int[][] retArray = new int[A.length][];
        int k;
        for (int i = 0; i < A.length; i++) {
            k = A[i].length;
            retArray[i] = new int[k];
            for (int j = 0; j < A.length; j++) {
                retArray[i][j] = A[i][--k] == 1 ? 0 : 1;
            }
        }

        return retArray;
    }

    public static void main(String[] args) {
        int[][] input = InputHelper.stringTo2DIntegerArray(args);
        FlippingAnImage o = new FlippingAnImage();
        System.out.println("Flipped Image : \n" + ArrayToString.convert2DArrayToString(o.flipAndInvertImage(input)));
    }
}