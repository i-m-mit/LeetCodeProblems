package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import Util.InputHelper;

/**
 * MeetingRooms
 */
public class MeetingRooms {
    public int solve(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] itv) -> itv[0]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int count = 0;
        for (int[] itv : intervals) {
            if (heap.isEmpty()) {
                count++;
                heap.offer(itv[1]);
            } else {
                if (itv[0] >= heap.peek()) {
                    heap.poll();
                } else {
                    count++;
                }

                heap.offer(itv[1]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] A = InputHelper.stringTo2DIntegerArray(args);
        MeetingRooms o = new MeetingRooms();
        System.out.println(o.solve(A));
    }
}