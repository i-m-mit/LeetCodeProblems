package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < a.size(); i++) {
            ArrayList<Integer> list = a.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i : rows) {
            ArrayList<Integer> list = a.get(i);
            for (int j = 0; j < list.size(); j++) {
                list.set(j, 0);
            }
        }
        for (int i : cols) {
            for (ArrayList<Integer> list : a) {
                list.set(i, 0);
            }
        }
    }

    public static void main(String[] args) {

    }

}