package Math;

import java.util.ArrayList;

/**
 * KthPermutationSequence
 */
public class KthPermutationSequence {
    public String getPermutation(int n, int k) {
        if (k > fact(n))
            return "";
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return getPermutation(list, k);
    }

    public String getPermutation(ArrayList<Integer> list, int k) {
        int n = list.size();
        if (n == 0)
            return "";

        int fact_n = fact(n - 1);
        int index = k / fact_n;
        if (k % fact_n == 0)
            index--;
        int num = list.get(index);
        list.remove(index);
        k = k - (fact_n * index);
        return num + getPermutation(list, k);
    }

    int fact(int n) {
        if (n > 12)
            return Integer.MAX_VALUE;

        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}