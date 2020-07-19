package Sorting;

import Util.ArrayToString;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        return new int[1][2];
    }

    // private void swap(int[][] queue, int to, int from) {
    // int[] temp = queue[to];
    // queue[to] = queue[from];
    // queue[from] = temp;
    // }

    public static void main(String[] args) {
        QueueReconstruction o = new QueueReconstruction();
        int[][] input = new int[0][0];
        int[][] retArray = o.reconstructQueue(input);

        System.out.println(ArrayToString.convert2DArrayToString(retArray));

    }
}