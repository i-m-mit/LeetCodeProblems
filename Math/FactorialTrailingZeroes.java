package Math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int i = 1;
        int pow = (int) Math.pow(5, i);
        int numberOf5 = 0;
        while (pow <= n) {
            numberOf5 += n / pow;
            pow = (int) Math.pow(5, ++i);
        }
        return numberOf5;
    }

    public int trailingZeroesV1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes o = new FactorialTrailingZeroes();
        System.out.println("Number of trailing zeros: " + o.trailingZeroes(20));
    }
}