package BitManipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReverseBits o = new ReverseBits();
        System.out.println(o.reverseBits(43261596));
    }
}