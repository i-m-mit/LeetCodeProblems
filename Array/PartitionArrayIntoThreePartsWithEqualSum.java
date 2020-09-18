package Array;

import Util.InputHelper;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }

        if (sum % 3 != 0) {
            return false;
        }

        int sumTarget = sum / 3;
        int sumPart = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            sumPart += A[i];
            if (sumPart == sumTarget) {
                count++;
                sumPart = 0;
            }

        }

        if (sumPart != 0 || count < 3)
            return false;
        return true;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        PartitionArrayIntoThreePartsWithEqualSum o = new PartitionArrayIntoThreePartsWithEqualSum();

        System.out.println(o.canThreePartsEqualSum(A));
    }
}
