package Greedy;

import Util.InputHelper;

/**
 * GasStation
 */
public class GasStation {
    // Brute Force Approach
    public int canCompleteCircuit(final int[] A, final int[] B) {
        int n = A.length;
        int gas;
        for (int i = 0; i < n; i++) {
            gas = A[i];
            gas -= B[i];
            for (int j = i + 1; j != i; j++) {
                if (j == n) {
                    j = -1;
                    continue;
                }
                if (gas < 0)
                    break;
                gas += A[j];
                gas -= B[j];
            }
            if (gas >= 0)
                return i;
        }
        return -1;
    }

    // Greedy Approach
    public int canCompleteCircuitV1(final int[] A, final int[] B) {
        int net_fuel = A[0], start_index = 0;
        for (int i = 1; i < A.length; i++) {
            net_fuel -= B[i - 1];
            if (net_fuel < 0) {
                net_fuel = 0;
                start_index = i;
            }
            net_fuel += A[i];
        }
        for (int i = 0; i <= start_index; i++) {
            net_fuel -= B[(i - 1 + B.length) % B.length];
            if (net_fuel < 0) {
                return -1;
            }
            net_fuel += A[i];
        }
        // System.out.println(net_fuel+" "+start_index);
        return start_index;
    }

    public static void main(String[] args) {
        int[] A = InputHelper.stringToIntegers(args);
        int[] B = InputHelper.stringToIntegers(args, 1);
        GasStation o = new GasStation();
        System.out.println(o.canCompleteCircuit(A, B));
    }
}