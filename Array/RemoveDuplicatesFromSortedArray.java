package Array;

import java.util.ArrayList;

/**
 * RemoveDuplicatesFromSortedArray
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int len = a.size();
        for (int i = len - 1; i > 0; i--) {
            if (a.get(i).compareTo(a.get(i - 1)) == 0) {
                a.remove(i);
                len--;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5000);
        list.add(5000);
        list.add(5000);
        RemoveDuplicatesFromSortedArray o = new RemoveDuplicatesFromSortedArray();
        System.out.println(o.removeDuplicates(list));
    }
}