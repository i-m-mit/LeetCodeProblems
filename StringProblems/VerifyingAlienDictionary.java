package StringProblems;

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] charOrder = new int[26];
        int index = 0;
        for (char c : order.toCharArray()) {
            charOrder[c - 'a'] = index++;
        }
        String word1;
        String word2;
        int len;
        search: for (int i = 0; i < words.length - 1; i++) {
            word1 = words[i];
            word2 = words[i + 1];
            len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (charOrder[word1.charAt(i) - 'a'] > charOrder[word2.charAt(i) - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }
            if (word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyingAlienDictionary o = new VerifyingAlienDictionary();
        System.out.println(o.isAlienSorted(args, "worldabcefghijkmnpqstuvxyz"));
    }
}
