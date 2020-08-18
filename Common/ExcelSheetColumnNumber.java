package Common;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int MULTIPIER = (int) Math.pow(26, s.length() - 1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += MULTIPIER * (s.charAt(i) - 'A' + 1);
            MULTIPIER /= 26;
        }

        return ans;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber o = new ExcelSheetColumnNumber();
        System.out.println("Cell No.: " + o.titleToNumber("ZY"));
    }
}