package Graph;

import Util.InputHelper;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] people = new int[N + 1];
        for (int[] pair : trust) {
            people[pair[0]]--;
            people[pair[1]]++;
        }

        for (int i = 1; i < people.length; i++) {
            if (people[i] == N - 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] trust = InputHelper.stringTo2DIntegerArray(args);
        FindTheTownJudge o = new FindTheTownJudge();
        System.out.println(o.findJudge(3, trust));
    }
}