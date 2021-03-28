package Array;

import java.util.ArrayList;

public class RemoveElementFromArray {
    public int removeElement(ArrayList<Integer> a, int b) {
        int n = a.size();
        int i, j;

        for (i = 0, j = 0; j < n; j++) {
            if (a.get(j) != b) {
                a.set(i, a.get(j));
                i++;
            }
        }
        int k = i;
        while (k < a.size()) {
            a.remove(k);
        }

        return i;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(1);
        list.add(3);
        RemoveElementFromArray o = new RemoveElementFromArray();
        System.out.println(o.removeElement(list, 1));
    }
}
