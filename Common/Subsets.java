package Common;

import java.util.ArrayList;
import java.util.List;

import Util.InputHelper;
import Util.ListToString;

public class Subsets {
    private List<List<Integer>> retSubsets;

    // Approach 1
    public List<List<Integer>> subsets(int[] nums) {
        retSubsets = new ArrayList<>();
        retSubsets.add(new ArrayList<>());
        for (int num : nums) {
            addSubsets(num);
        }
        return retSubsets;
    }

    private void addSubsets(int num) {
        List<List<Integer>> iter = new ArrayList<>(retSubsets);
        for (List<Integer> subList : iter) {
            List<Integer> toAdd = new ArrayList<>(subList);
            toAdd.add(num);
            if (!retSubsets.contains(toAdd)) {
                retSubsets.add(toAdd);
            }
        }
    }

    // Backtracking Approach
    int n, k;

    public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        // if the combination is done
        if (curr.size() == k)
            retSubsets.add(new ArrayList<>(curr));

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.add(nums[i]);
            // use next integers to complete the combination
            backtrack(i + 1, curr, nums);
            // backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsetsV1(int[] nums) {
        n = nums.length;
        retSubsets = new ArrayList<>();
        for (k = 0; k < n + 1; ++k) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return retSubsets;
    }

    // Lexicographic (Binary Sorted) Subsets approach
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1')
                    curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        Subsets o = new Subsets();
        List<List<Integer>> output = o.subsetsV2(input);
        System.out.println(ListToString.convert2DListToString(output));
        System.out.println("LENGTH : " + output.size());

    }
}