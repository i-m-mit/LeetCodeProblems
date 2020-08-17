package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class ReplaceElementsGreatestElementOnRightSide {
    public int[] replaceElements(int[] arr) {
        int max = -1;
        int iter;
        for (int i = arr.length - 1; i >= 0; i--) {
            iter = arr[i];
            arr[i] = max;
            if (iter > max) {
                max = iter;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        ReplaceElementsGreatestElementOnRightSide o = new ReplaceElementsGreatestElementOnRightSide();
        System.out.println("New array: " + ArrayToString.convert1DArrayToString(o.replaceElements(input)));
    }
}