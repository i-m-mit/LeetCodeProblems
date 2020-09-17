package Common;

import Util.InputHelper;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int note5 = 0;
        int note10 = 0;
        for (int bill : bills) {
            switch (bill) {
                case 10:
                    if (note5 > 0) {
                        note5--;
                        note10++;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (note10 >= 1 && note5 >= 1) {
                        note5--;
                        note10--;
                    } else if (note5 >= 3) {
                        note5 -= 3;
                    } else {
                        return false;
                    }
                    break;
                default:
                    note5++;
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = InputHelper.stringToIntegers(args);
        LemonadeChange o = new LemonadeChange();

        System.out.println(o.lemonadeChange(bills));
    }
}
