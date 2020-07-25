package Tree;

public class Trie {

    class TrieNode {
        public static final int R = 26;
        TrieNode[] map;
        boolean eow;

        TrieNode() {
            map = new TrieNode[R];
            eow = false;
        }

        public boolean containsKey(char key) {
            return map[key - 'a'] != null;
        }

        public void putKey(char key) {
            map[key - 'a'] = new TrieNode();
        }

        public TrieNode get(char key) {
            return map[key - 'a'];
        }
    }

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode itr = root;
        for (char c : word.toCharArray()) {
            if (!itr.containsKey(c)) {
                itr.putKey(c);
            }
            itr = itr.get(c);
        }
        itr.eow = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode itr = root;
        for (char c : word.toCharArray()) {
            if (!itr.containsKey(c)) {
                return false;
            }
            itr = itr.get(c);
        }
        return itr.eow;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode itr = root;
        for (char c : prefix.toCharArray()) {
            if (!itr.containsKey(c)) {
                return false;
            }
            itr = itr.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
    }
}