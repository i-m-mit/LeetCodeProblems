package StringProblems;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ret = 0;
        char[] arr = s.toCharArray();
        int l, r;
        for (int i = 0; i < arr.length - 1; i++) {
            l = i;
            r = i + 1;
            while (l >= 0 && r < arr.length && arr[l] != arr[r] && arr[l--] == arr[i] && arr[r++] == arr[i + 1]) {
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        CountBinarySubstrings o = new CountBinarySubstrings();
        System.out.println(o.countBinarySubstrings("00110011"));
    }
}
