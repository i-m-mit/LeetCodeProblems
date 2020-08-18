package Tree;

import CommonDS.TreeNode;
import Util.InputHelper;

public class ConvertSortedArrayBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start < 0 || end < 0 || end >= nums.length || start >= nums.length || start > end) {
            return null;
        }
        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = construct(nums, start, mid - 1);
        node.right = construct(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = InputHelper.stringToIntegers(args);
        ConvertSortedArrayBinarySearchTree o = new ConvertSortedArrayBinarySearchTree();
        TreeNode root = o.sortedArrayToBST(nums);
        System.out.println(root.toString());
    }
}