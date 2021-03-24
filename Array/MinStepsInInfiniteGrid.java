package Array;

import Util.InputHelper;

public class MinStepsInInfiniteGrid {
    public int coverPoints(int[] A, int[] B) {
        int step = 0;
        int x = A[0];
        int y = B[0];
        int destX, destY;
        for (int i = 1; i < A.length; i++) {
            destX = A[i];
            destY = B[i];

            int diffX = Math.abs(x > destX ? x - destX : destX - x);
            int diffY = Math.abs(y > destY ? y - destY : destY - y);
            step += Math.min(diffX, diffY) + Math.abs(diffX - diffY);
            x = destX;
            y = destY;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        int[] B = InputHelper.stringToIntegers(args, 1);
        MinStepsInInfiniteGrid o = new MinStepsInInfiniteGrid();
        int result = o.coverPoints(A, B);
        System.out.println("Result: " + result);
    }

}