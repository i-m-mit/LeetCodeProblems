package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list;
        List<Integer> lastList;
        list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1; i <= rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            lastList = res.get(i - 1);
            for (int j = 0; j < lastList.size() - 1; j++) {
                list.add(lastList.get(j) + lastList.get(j + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res.get(rowIndex);
    }

    public List<Integer> getRowV1(int rowIndex) {
        int[][] arr = new int[rowIndex + 1][];
        int j;
        for (int i = 0; i <= rowIndex; i++) {
            arr[i] = new int[i + 1];
            arr[i][0] = 1;
            for (j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
            if (j < i + 1) {
                arr[i][j] = 1;
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i : arr[rowIndex]) {
            ret.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        PascalsTriangleII o = new PascalsTriangleII();
        System.out.println(o.getRowV1(0));
    }
}
