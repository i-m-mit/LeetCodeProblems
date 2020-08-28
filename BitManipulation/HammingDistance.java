package BitManipulation;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int d = 0;
        while (x > 0 || y > 0) {
            d += (x & 1) ^ (y & 1);
            x >>= 1;
            y >>= 1;
        }
        return d;
    }

    public int hammingDistanceV1(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        HammingDistance o = new HammingDistance();
        System.out.println("Hamming Distance: " + o.hammingDistance(1, 4));
    }
}