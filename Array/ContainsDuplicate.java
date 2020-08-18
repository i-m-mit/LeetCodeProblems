package Array;

import java.util.HashSet;
import java.util.Set;

import Util.InputHelper;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        ContainsDuplicate o = new ContainsDuplicate();
        System.out.println(o.containsDuplicate(input) ? "Contains" : "Does not Contain");
    }

}