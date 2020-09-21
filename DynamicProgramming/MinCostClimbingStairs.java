package DynamicProgramming;

import Util.InputHelper;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int prevStepped = 0;
        int prevUnstepped = 0;
        int curStepped;
        for (int i : cost) {
            curStepped = Math.min(prevStepped, prevUnstepped) + i;
            prevUnstepped = prevStepped;
            prevStepped = curStepped;
        }
        return Math.min(prevStepped, prevUnstepped);
    }

    public static void main(String[] args) {
        int[] cost = InputHelper.stringToIntegers(args);
        MinCostClimbingStairs o = new MinCostClimbingStairs();
        System.out.println("Minimum cost: " + o.minCostClimbingStairs(cost));
    }
}
