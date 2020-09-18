package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        List<String> resMap = new ArrayList<>();
        String cur;
        int sum;
        for (int i = 0; i < list2.length; i++) {
            cur = list2[i];
            if (map.containsKey(cur)) {
                sum = map.get(cur) + i;
                if (min > sum) {
                    min = sum;
                    resMap.clear();
                    resMap.add(cur);
                } else if (min == sum) {
                    resMap.add(cur);
                }
            }
        }

        return resMap.toArray(new String[resMap.size()]);
    }

    public static void main(String[] args) {
        MinimumIndexSumOfTwoLists o = new MinimumIndexSumOfTwoLists();
        String[] list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        String[] list2 = new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        System.out.println(Arrays.toString(o.findRestaurant(list1, list2)));
    }
}
