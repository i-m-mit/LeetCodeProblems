package Common;

import java.util.ArrayList;
import java.util.List;

import Util.InputHelper;
import Util.ListToString;

public class Permutations {
    private List<List<Integer>> permuations;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        permuations = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> output = new ArrayList<>();
            output.add(nums[0]);
            permuations.add(output);
            return permuations;
        }
        List<Integer> initList = new ArrayList<>();
        List<Integer> currentList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++)
            currentList.add(nums[i]);
        makePermutaion(initList, currentList);
        return permuations;
    }

    private void makePermutaion(List<Integer> currentList, List<Integer> nums) {
        if (nums.size() == 2) {
            List<Integer> p1 = new ArrayList<>(currentList);
            p1.add(nums.get(0));
            p1.add(nums.get(1));
            permuations.add(p1);
            p1 = new ArrayList<>(currentList);
            p1.add(nums.get(1));
            p1.add(nums.get(0));
            permuations.add(p1);
        } else {
            for (int i = 0; i < nums.size(); i++) {
                Integer num = nums.get(i);
                currentList.add(num);
                nums.remove(i);
                makePermutaion(currentList, nums);
                currentList.remove(currentList.size() - 1);
                nums.add(i, num);
            }
        }
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        Permutations o = new Permutations();
        List<List<Integer>> output = o.permute(input);
        System.out.println(ListToString.convert2DListToString(output));
    }
}