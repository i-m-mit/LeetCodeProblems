package Array;

import Util.ArrayToString;
import Util.InputHelper;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (oldColor == newColor) {
            return;
        }
        image[sr][sc] = newColor;
        if (sr - 1 >= 0 && image[sr - 1][sc] == oldColor) {
            dfs(image, sr - 1, sc, newColor, oldColor);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == oldColor) {
            dfs(image, sr, sc - 1, newColor, oldColor);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == oldColor) {
            dfs(image, sr + 1, sc, newColor, oldColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == oldColor) {
            dfs(image, sr, sc + 1, newColor, oldColor);
        }
    }

    public static void main(String[] args) {
        int[][] image = InputHelper.stringTo2DIntegerArray(args);
        FloodFill o = new FloodFill();
        System.out.println(ArrayToString.convert2DArrayToString(o.floodFill(image, 1, 1, 1)));
    }
}
