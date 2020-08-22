package Math;

public class FindSqrt {
    public int mySqrt(int x) {
        int r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        FindSqrt o = new FindSqrt();
        System.out.println("Square root: " + o.mySqrt(4));
    }
}