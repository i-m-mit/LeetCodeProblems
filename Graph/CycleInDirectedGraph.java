package Graph;

import java.util.HashMap;

import Util.InputHelper;

import java.util.ArrayList;

/**
 * CycleInDirectedGraph
 */
public class CycleInDirectedGraph {
    HashMap<Integer, ArrayList<Integer>> edges;

    public int solve(int A, int[][] B) {
        edges = new HashMap<>();
        for (int[] edge : B) {
            ArrayList<Integer> list = edges.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            edges.put(edge[0], list);
        }

        boolean[] colors = new boolean[A];
        int found = 0;
        for (int i = 1; i <= A; i++) {
            found = traverse(1, colors);
            if (found == 1)
                return 1;
        }
        return 0;
    }

    private int traverse(int node, boolean[] colors) {
        if (colors[node - 1]) {
            return 1;
        }
        colors[node - 1] = true;
        if (edges.containsKey(node)) {
            for (int edge : edges.get(node)) {
                int found = traverse(edge, colors);
                if (found == 1) {
                    return found;
                }
            }
        }
        colors[node - 1] = false;

        return 0;
    }

    public int solveV1(int n, int[][] nums) {
        int[] arr = new int[n + 1];
        int i, j;
        for (i = 0; i <= n; ++i) {
            arr[i] = i;
        }
        for (i = 0; i < nums.length; ++i) {
            arr[nums[i][1]] = nums[i][0];
            j = arr[nums[i][0]];
            while (j != arr[j]) {
                if (arr[j] == nums[i][1]) {
                    return 1;
                }
                j = arr[j];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] B = InputHelper.stringTo2DIntegerArray(args);
        CycleInDirectedGraph o = new CycleInDirectedGraph();
        System.out.println(o.solve(5, B));
    }
}