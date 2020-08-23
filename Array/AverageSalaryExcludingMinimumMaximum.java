package Array;

import Util.InputHelper;

public class AverageSalaryExcludingMinimumMaximum {
    public double average(int[] salary) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int count = salary.length;
        for (int n : salary) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        for (int i : salary) {
            if (i != min && i != max) {
                sum += i;
            } else {
                count--;
            }
        }

        return ((double) sum) / count;
    }

    public static void main(String[] args) {
        int[] salary = InputHelper.stringToIntegers(args);
        AverageSalaryExcludingMinimumMaximum o = new AverageSalaryExcludingMinimumMaximum();
        System.out.println("Average: " + o.average(salary));
    }
}