package Common;

public class NumberStepsReduceNumberToZero {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            step++;
        }
        return step;
    }

    public static void main(String[] args) {
        NumberStepsReduceNumberToZero o = new NumberStepsReduceNumberToZero();
        System.out.println("Number of steps: " + o.numberOfSteps(14));
    }
}