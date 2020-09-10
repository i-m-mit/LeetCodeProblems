package BitManipulation;

public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int iter = n & 1;
        n >>= 1;
        while (n > 0) {
            if (iter == (n & 1)) {
                return false;
            }
            iter = (n & 1);
            n >>= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits o = new BinaryNumberWithAlternatingBits();

        System.out.println(o.hasAlternatingBits(5));
    }
}
