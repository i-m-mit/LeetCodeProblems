package Array;

public class XOROperationInArray {
    public int xorOperation(int n, int start) {
        int ret = start;
        for (int i = 1; i < n; i++) {
            ret = ret ^ (start + 2 * i);
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 5;
        int start = 0;
        XOROperationInArray o = new XOROperationInArray();
        System.out.println(o.xorOperation(n, start));
    }
}