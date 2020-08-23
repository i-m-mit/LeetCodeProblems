package Math;

public class Maximum69Number {
    public int maximum69Number(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(digits));
    }

    public static void main(String[] args) {
        Maximum69Number o = new Maximum69Number();
        System.out.println("Maximum number: " + o.maximum69Number(9669));
    }
}