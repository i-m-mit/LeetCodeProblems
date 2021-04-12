package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * CombinationSum
 */
public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(A);
        ArrayList<Integer> input = new ArrayList<>(set);
        Collections.sort(input);
        iterate(0, input, new ArrayList<>(), 0, B, result);
        return result;
    }

    private void iterate(int index, ArrayList<Integer> nums, ArrayList<Integer> current, int sum, int target,
            ArrayList<ArrayList<Integer>> result) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            int num = nums.get(i);
            sum += num;
            current.add(num);
            iterate(i, nums, current, sum, target, result);
            sum -= num;
            current.remove(current.size() - 1);
        }
    }
}