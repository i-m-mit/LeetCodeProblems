package Greedy;

import java.util.Arrays;

import Util.InputHelper;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1;
        int gi = g.length - 1;
        int count = 0;
        while (si >= 0 && gi >= 0) {
            if (s[si] < g[gi]) {
                gi--;
            } else {
                count++;
                si--;
                gi--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = InputHelper.stringToIntegers(args);
        int[] s = InputHelper.stringToIntegers(args, 1);
        AssignCookies o = new AssignCookies();
        System.out.println(o.findContentChildren(g, s));
    }
}
