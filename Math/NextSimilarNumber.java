package Math;

import java.util.Arrays;

public class NextSimilarNumber {
    public String solve(String A) {
        int n = A.length();
        if (n < 2)
            return "-1";
        char[] stringArray = A.toCharArray();
        boolean isDescending = true;
        int index = 0;
        for (int i = n - 1; i > 0; i--) {
            if (stringArray[i] > stringArray[i - 1]) {
                isDescending = false;
                index = i - 1;
                break;
            }
        }
        if (isDescending) {
            return "-1";
        }
        for (int i = n - 1; i > index; i--) {
            if (stringArray[i] > stringArray[index]) {
                char swap = stringArray[i];
                stringArray[i] = stringArray[index];
                stringArray[index] = swap;
                break;
            }
        }

        Arrays.sort(stringArray, index + 1, n);
        return new String(stringArray);
    }

    public static void main(String[] args) {
        NextSimilarNumber o = new NextSimilarNumber();
        System.out.println(o.solve("740948"));
    }
}