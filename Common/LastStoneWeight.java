package Common;

import java.util.PriorityQueue;

import Util.InputHelper;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i : stones) {
            pq.offer(i);
        }
        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = InputHelper.stringToIntegers(args);
        LastStoneWeight o = new LastStoneWeight();
        System.out.println(o.lastStoneWeight(stones));
    }
}
