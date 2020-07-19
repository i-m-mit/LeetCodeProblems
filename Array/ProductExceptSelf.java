package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] retArray = new int[nums.length];
        retArray[0] = 1;
        int mul = 1;
        for (int i = 1; i < nums.length; i++) {
            mul *= nums[i - 1];
            retArray[i] = mul;
        }
        mul = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            mul *= nums[i + 1];
            retArray[i] *= mul;
        }
        return retArray;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        ProductExceptSelf o = new ProductExceptSelf();
        int[] output = o.productExceptSelf(input);
        System.out.println("Products:");
        System.out.println(ArrayToString.convert1DArrayToString(output));
    }
}