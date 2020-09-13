package StringProblems;

public class MaximumScoreAfterSplittingString {
    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arr.length; i++) {
            sumRight += arr[i] == '1' ? 1 : 0;
        }
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == '1') {
                sumRight--;
            } else {
                sumLeft++;
            }
            if (sum < sumLeft + sumRight) {
                sum = sumLeft + sumRight;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        MaximumScoreAfterSplittingString o = new MaximumScoreAfterSplittingString();

        System.out.println(o.maxScore("011101"));
    }
}
