package BitManipulation;

public class NumberComplement {
    public int findComplement(int num) {
        return ((1 << Integer.toBinaryString(num).length()) - 1) ^ num;
    }

    public static void main(String[] args) {
        NumberComplement o = new NumberComplement();
        System.out.println(o.findComplement(5));
    }
}
