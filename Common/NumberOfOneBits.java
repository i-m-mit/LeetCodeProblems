package Common;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        NumberOfOneBits o = new NumberOfOneBits();
        System.out.println(o.hammingWeight(00000000000000000000000000001011));
    }
}