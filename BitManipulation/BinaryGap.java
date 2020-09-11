package BitManipulation;

public class BinaryGap {
    public int binaryGap(int N) {
        int ans = 0;
        int i = 0;
        int last = -1;
        while (N > 0) {
            if ((N & 1) == 1) {
                if (last >= 0) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            N >>= 1;
            i++;
        }
        return ans;
    }
}
