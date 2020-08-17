package HashTable;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int count = 0;

        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbb";
        JewelsAndStones o = new JewelsAndStones();
        System.out.println("Total Jewels: " + o.numJewelsInStones(J, S));
    }
}