package Common;

public class CountingBits {
    public int[] countBits(int num) {
        int[] retArray = new int[num + 1];
        retArray[0] = 0;
        int powerOfTwo = 0;
        int powerElement = (int) Math.pow(2, powerOfTwo);
        int index = 0;
        for (int i = 1; i <= num; i++) {
            if (i == (int) Math.pow(2, powerOfTwo)) {
                retArray[i] = 1;
                powerElement = (int) Math.pow(2, powerOfTwo++);
            } else {
                index = i % powerElement;
                retArray[i] = 1 + retArray[index];
            }
        }

        return retArray;
    }

    public int[] countBitsV1(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i / 2];
            if (i % 2 == 1)
                bits[i]++;
        }
        return bits;
    }

    public int[] countBitsV2(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            bits[i] = bits[i / 2];
            if (i % 2 == 1)
                bits[i]++;
        }
        return bits;
    }

    public static void main(String[] args) {
        CountingBits o = new CountingBits();
        int[] retVal = o.countBitsV2(15);
        for (int i = 0; i < retVal.length; i++) {
            System.out.println(i + " -> " + retVal[i]);
        }
    }
}