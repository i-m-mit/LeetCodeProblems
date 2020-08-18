package Array;

import Util.InputHelper;

public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int x, y;
        for (int i = 1; i < points.length; i++) {
            x = Math.abs(points[i - 1][0] - points[i][0]);
            y = Math.abs(points[i - 1][1] - points[i][1]);
            time += x >= y ? x : y;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] points = InputHelper.stringTo2DIntegerArray(args);
        MinimumTimeVisitingAllPoints o = new MinimumTimeVisitingAllPoints();
        System.out.println("Time to visit all the points: " + o.minTimeToVisitAllPoints(points));
    }
}