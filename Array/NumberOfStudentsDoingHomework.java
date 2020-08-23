package Array;

import Util.InputHelper;

public class NumberOfStudentsDoingHomework {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] startTime = InputHelper.stringToIntegers(args);
        int[] endTime = InputHelper.stringToIntegers(args, 1);
        NumberOfStudentsDoingHomework o = new NumberOfStudentsDoingHomework();
        System.out.println("Number of students: " + o.busyStudent(startTime, endTime, 5));
    }
}