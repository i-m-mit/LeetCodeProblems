package HashTable;

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        char[] map = new char[26];
        for (char c : text.toCharArray()) {
            map[c - 'a']++;
        }
        int ib = 'b' - 'a';
        int ia = 0;
        int il = 'l' - 'a';
        int io = 'o' - 'a';
        int in = 'n' - 'a';
        int count = 0;
        while (true) {
            if (map[ib] > 0 && map[ia] > 0 && map[il] > 1 && map[io] > 1 && map[in] > 0) {
                map[ib] -= 1;
                map[ia] -= 1;
                map[il] -= 2;
                map[io] -= 2;
                map[in] -= 1;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
