package Common;

public class PowerOfThree {
    final int MAX = (int) Math.pow(3, 19);

    public boolean isPowerOfThree(int n) {
        return n != 0 && MAX % n == 0;
    }

    public boolean isPowerOfThreeV1(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}