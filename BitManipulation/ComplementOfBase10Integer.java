
package BitManipulation;

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }

        int pow = Integer.toBinaryString(N).length();
        int com = ((int) Math.pow(2, pow)) - 1;

        return com ^ N;
    }

    public static void main(String[] args) {
        ComplementOfBase10Integer o = new ComplementOfBase10Integer();
        System.out.println(o.bitwiseComplement(5));
    }
}
