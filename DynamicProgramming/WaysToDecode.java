package DynamicProgramming;

/**
 * WaysToDecode
 */
public class WaysToDecode {
    long M = 1000000007;
    int[] memo;

    public int numDecodings(String A) {
        int n = A.length();
        if (n == 1 && A.charAt(0) == '0')
            return 0;
        memo = new int[A.length() + 1];
        return countDecoding(A.toCharArray(), n);
    }

    int countDecoding(char[] digits, int n) {
        if (n == 0 || n == 1)
            return 1;

        // for base condition "01123" should return 0
        if (digits[0] == '0')
            return 0;
        if (memo[n] != 0) {
            return memo[n];
        }
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1' || (digits[n - 2] == '2' && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);
        memo[n] = (int) (count % M);

        return (int) (count % M);
    }
}