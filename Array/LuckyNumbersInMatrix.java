package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Util.InputHelper;
import Util.ListToString;

public class LuckyNumbersInMatrix {
    // Approach 1
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < row[i]) {
                    row[i] = matrix[i][j];
                }
                if (matrix[i][j] > col[j]) {
                    col[j] = matrix[i][j];
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int r : row) {
            for (int c : col) {
                if (r == c) {
                    list.add(r);
                }
            }
        }

        return list;
    }

    // Approach 2
    public List<Integer> luckyNumbersV1(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        for (int row = 0; row < matrix.length; row++) {
            int minCol = minColInRow(matrix, row);
            int value = matrix[row][minCol];
            if (checkIfMaxInCol(matrix, minCol, value)) {
                result.add(value);
            }
        }

        return result;
    }

    private int minColInRow(int[][] matrix, int row) {
        int minIndex = 0, min = matrix[row][minIndex];
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] < min) {
                min = matrix[row][col];
                minIndex = col;
            }
        }
        return minIndex;
    }

    private boolean checkIfMaxInCol(int[][] matrix, int col, int value) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > value)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = InputHelper.stringTo2DIntegerArray(args);
        LuckyNumbersInMatrix o = new LuckyNumbersInMatrix();
        System.out.println("Lucky Numbers: " + ListToString.convertListToString(o.luckyNumbers(matrix)));
    }
}