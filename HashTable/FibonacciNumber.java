package HashTable;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    // Memoization using HashMap and Recursion
    Map<Integer, Integer> map;

    public FibonacciNumber() {
        map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
    }

    public int fib(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }
        int retVal = fib(N - 1) + fib(N - 2);
        map.put(N, retVal);
        return retVal;
    }

    // Iterative DP Approach
    public int fibV1(int N) {
        if (N <= 2) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 1;
        int fib = 1;
        for (int i = 2; i < N; i++) {
            fib = prev1 + prev2;
            prev1 = prev2;
            prev2 = fib;
        }
        return fib;
    }

    // Matrix Exponentiation
    public int fibV2(int N) {
        if (N <= 1) {
            return N;
        }

        int[][] A = new int[][] { { 1, 1 }, { 1, 0 } };
        matrixPower(A, N - 1);
        return A[0][0];
    }

    private void matrixPower(int[][] A, int N) {
        if (N <= 1) {
            return;
        }
        matrixPower(A, N / 2);
        multiply(A, A);

        int[][] B = new int[][] { { 1, 1 }, { 1, 0 } };
        if (N % 2 != 0) {
            multiply(A, B);
        }

    }

    void multiply(int[][] A, int[][] B) {
        int x = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        int y = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        int z = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        int w = A[1][0] * B[0][1] + A[1][1] * B[1][1];

        A[0][0] = x;
        A[0][1] = y;
        A[1][0] = z;
        A[1][1] = w;
    }

    public static void main(String[] args) {
        FibonacciNumber o = new FibonacciNumber();
        System.out.println(o.fibV2(6));
    }
}
