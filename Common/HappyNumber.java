
package Common;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();
        int sum;
        int digit;
        while (map.add(n)) {
            sum = 0;
            while (n > 0) {
                digit = n % 10;
                n /= 10;
                sum += digit * digit;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber o = new HappyNumber();
        System.out.println(o.isHappy(19) ? "Happy Number" : "Not a Happy Number");
    }
}