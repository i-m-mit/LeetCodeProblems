package Common;

import java.util.ArrayList;
import java.util.List;

import Util.ListToString;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> retList = new ArrayList<>();
        boolean selfDividing;
        int iter;
        for (int i = left; i <= right; i++) {
            int j = i % 10;
            iter = i;
            selfDividing = true;
            while (iter != 0) {
                if (j == 0 || i % j != 0) {
                    selfDividing = false;
                    break;
                }
                iter /= 10;
                j = iter % 10;
            }
            if (selfDividing) {
                retList.add(i);
            }

        }
        return retList;
    }

    public static void main(String[] args) {
        SelfDividingNumbers o = new SelfDividingNumbers();
        int left = 1;
        int right = 22;
        System.out.println("Self dividing numbers between " + left + " & " + right + ": \n"
                + ListToString.convertListToString(o.selfDividingNumbers(left, right)));
    }
}