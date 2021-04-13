package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

import Util.ArrayToString;
import Util.InputHelper;

/**
 * SlidingWindowMaximum
 */
public class SlidingWindowMaximum {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] slidingMaximum(final int[] arr, int k) {
        int n = arr.length;
        int[] result = new int[n - k + 1];
        int iter = 0;
        Deque<Integer> Qi = new LinkedList<Integer>();

        int i;
        for (i = 0; i < k; ++i) {
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);
        }
        for (; i < n; ++i) {
            result[iter++] = arr[Qi.peek()];
            while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
                Qi.removeFirst();
            while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
                Qi.removeLast();
            Qi.addLast(i);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        SlidingWindowMaximum o = new SlidingWindowMaximum();
        System.out.println(ArrayToString.convert1DArrayToString(o.slidingMaximum(A, 2)));
    }
}