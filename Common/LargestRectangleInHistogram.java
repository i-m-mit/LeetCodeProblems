package Common;

import java.util.ArrayList;
import java.util.Stack;

import Util.InputHelper;

/**
 * LargestRectangleInHistogram
 */
public class LargestRectangleInHistogram {
    int getMaxArea(ArrayList<Integer> hist) {
        int n = hist.size();
        Stack<Integer> s = new Stack<>();

        int max_area = 0;
        int tp;
        int area_with_top;

        int i = 0;
        while (i < n) {
            if (s.empty() || hist.get(s.peek()) <= hist.get(i))
                s.push(i++);

            else {
                tp = s.peek();
                s.pop();

                area_with_top = hist.get(tp) * (s.empty() ? i : i - s.peek() - 1);

                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        while (s.empty() == false) {
            tp = s.peek();
            s.pop();
            area_with_top = hist.get(tp) * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        return max_area;

    }

    public static void main(String[] args) {
        int[] hist = InputHelper.stringToIntegers(args);
        LargestRectangleInHistogram o = new LargestRectangleInHistogram();
        System.out.println(o.getMaxArea(hist));
    }
}