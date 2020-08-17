package Array;

import Util.ArrayToString;

public class FindNUniqueIntegersSumZero {
    public int[] sumZero(int n) {
        int[] retArray = new int[n];
        int iter = -n / 2;
        boolean even = n % 2 == 0;
        for (int i = 0; i < retArray.length; i++) {
            if (even && iter == 0) {
                iter++;
            }
            retArray[i] = iter++;
        }
        return retArray;
    }

    public static void main(String[] args) {
        FindNUniqueIntegersSumZero o = new FindNUniqueIntegersSumZero();

        System.out.println("List: " + ArrayToString.convert1DArrayToString(o.sumZero(5)));
    }
}