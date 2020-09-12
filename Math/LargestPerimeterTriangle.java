package Math;

import java.util.Arrays;

import Util.InputHelper;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);

        LargestPerimeterTriangle o = new LargestPerimeterTriangle();
        System.out.println(o.largestPerimeter(A));
    }
}
