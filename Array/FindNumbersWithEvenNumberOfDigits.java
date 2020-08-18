package Array;

import Util.InputHelper;

public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            count += i > 9 && i < 100 || i > 999 && i < 10000 || i == 100000 ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        FindNumbersWithEvenNumberOfDigits o = new FindNumbersWithEvenNumberOfDigits();
        System.out.println("Number of elements with even digits: " + o.findNumbers(nums));
    }
}