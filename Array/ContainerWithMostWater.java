package Array;

import Util.InputHelper;

public class ContainerWithMostWater {

    // Brute-Force Approach
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    // Two Pointers Approach
    public int maxAreaV1(int[] height) {
        int left = 0, right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[] input = InputHelper.stringToIntegers(args);
        ContainerWithMostWater o = new ContainerWithMostWater();
        System.out.println("Max water that can be contained : " + o.maxAreaV1(input));
    }
}