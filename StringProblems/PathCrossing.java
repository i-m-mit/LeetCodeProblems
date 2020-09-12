package StringProblems;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<Integer> set = new HashSet<>();
        int x = 0;
        int y = 0;
        int base = 10001;
        set.add(x * base + y);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N': {
                    x++;
                }
                    break;
                case 'S': {
                    x--;
                }
                    break;
                case 'E': {
                    y++;
                }
                    break;
                default: {
                    y--;
                }
                    break;
            }
            if (!set.add(x * base + y)) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        PathCrossing o = new PathCrossing();
        System.out.println(o.isPathCrossing("NESWW"));
    }
}
