package Array;

import java.util.ArrayList;
import java.util.List;

import Util.InputHelper;
import Util.ListToString;

public class Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] iter;

        for (int i = 0; i < k; i++) {
            iter = new int[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (c == 0) {
                        if (r == 0) {
                            iter[r][c] = grid[n - 1][m - 1];
                        } else {
                            iter[r][c] = grid[r - 1][m - 1];
                        }
                    } else {
                        iter[r][c] = grid[r][c - 1];
                    }
                }
            }
            grid = iter;
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                cur.add(grid[i][j]);
            }
            ret.add(cur);
        }
        return ret;
    }

    public List<List<Integer>> shiftGridV1(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> ret = new ArrayList<>();
        int lastIndex = n * m;
        int iter = lastIndex - (k % lastIndex);
        int r, c;
        for (int i = 0; i < n; i++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < m; j++, iter++) {
                if (iter == lastIndex) {
                    iter = 0;
                }
                r = iter / m;
                c = iter % m;
                cur.add(grid[r][c]);
            }
            ret.add(cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] grid = InputHelper.stringTo2DIntegerArray(args);

        Shift2DGrid o = new Shift2DGrid();
        System.out.println(ListToString.convert2DListToString(o.shiftGridV1(grid, 4)));
    }
}
