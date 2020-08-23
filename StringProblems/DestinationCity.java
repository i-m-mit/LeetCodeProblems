package StringProblems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> list : paths) {
            set.add(list.get(1));
        }
        for (List<String> list : paths) {
            set.remove(list.get(0));
        }
        return set.iterator().next();
    }
}