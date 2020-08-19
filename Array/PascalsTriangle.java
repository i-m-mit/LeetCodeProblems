package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows <= 0) {
            return res;
        }
        if (numRows >= 1) {
            res.add(new ArrayList<>() {
                {
                    add(1);
                }
            });
        }
        if (numRows >= 2) {
            res.add(new ArrayList<>() {
                {
                    add(1);
                    add(1);
                }
            });
        }

        List<Integer> list;
        List<Integer> lastList;
        for (int i = 2; i < numRows; i++) {
            list = new ArrayList<>();
            list.add(1);
            lastList = res.get(i - 1);
            for (int j = 0; j < lastList.size() - 1; j++) {
                list.add(lastList.get(j) + lastList.get(j + 1));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        PascalsTriangle o = new PascalsTriangle();
        System.out.println(o.generate(5));
    }
}