package Graph;

/**
 * WordSearchBoard
 */
public class WordSearchBoard {

    public int exist(String[] A, String B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length(); j++) {
                if (B.charAt(0) == A[i].charAt(j)) {
                    if (dfs(i, j, 0, A, B))
                        return 1;
                }
            }
        }
        return 0;

    }

    public static boolean dfs(int r, int c, int k, String[] board, String word) {
        if (k >= word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length() || word.charAt(k) != board[r].charAt(c)) {
            return false;
        }

        boolean w = dfs(r - 1, c, k + 1, board, word);
        boolean x = dfs(r, c - 1, k + 1, board, word);
        boolean y = dfs(r + 1, c, k + 1, board, word);
        boolean z = dfs(r, c + 1, k + 1, board, word);

        if (w || x || y || z) {
            return true;
        }
        return false;

    }
}