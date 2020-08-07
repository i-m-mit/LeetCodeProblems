package Common;

import Util.InputHelper;

public class NumberOfIslands {
    final char ISLAND = '1';

    // DFS Solution
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ISLAND) {
                    sink(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void sink(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != ISLAND) {
            return;
        }
        grid[i][j] = '#';
        sink(i - 1, j, grid);
        sink(i + 1, j, grid);
        sink(i, j - 1, grid);
        sink(i, j + 1, grid);

    }

    public static void main(String[] args) {
        char[][] input = InputHelper.stringTo2DCharArray(args);
        NumberOfIslands o = new NumberOfIslands();
        System.out.println("Total Number of Islands : " + o.numIslands(input));
    }
}