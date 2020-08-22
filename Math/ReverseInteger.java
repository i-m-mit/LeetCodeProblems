package Math;

public class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;
        int pop;
        x = Math.abs(x);
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger o = new ReverseInteger();
        System.out.println("Reversed Integer: " + o.reverse(1534236469));
    }
}