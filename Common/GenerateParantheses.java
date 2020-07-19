package Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.ListToString;

public class GenerateParantheses {
    public List<String> generateParenthesis(int n) {
        List<String> retList = new ArrayList<>();
        if (n == 0) {
            retList.add("");
            return retList;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        if (n == 1) {
            retList.add("()");
        } else {
            if (!map.containsKey(n - 1)) {
                map.put(n - 1, generateParenthesis(n - 1));
            }
            List<String> middle = map.get(n - 1);
            for (String midString : middle) {
                retList.add("(" + midString + ")");
            }
            List<String> left;
            List<String> right;
            for (int i = n - 1; i > 0; i--) {
                if (!map.containsKey(i)) {
                    map.put(i, generateParenthesis(i));
                }
                if (!map.containsKey(n - i)) {
                    map.put(n - i, generateParenthesis(n - i));
                }
                left = map.get(i);
                right = map.get(n - i);
                String toAdd;
                for (String leftString : left) {
                    for (String rightString : right) {
                        toAdd = leftString + rightString;
                        if (!retList.contains(toAdd)) {
                            retList.add(toAdd);
                        }
                    }
                }
            }
        }
        return retList;
    }

    public List<String> generateParenthesisV1(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        GenerateParantheses o = new GenerateParantheses();
        List<String> output = o.generateParenthesisV1(4);
        System.out.println(ListToString.convertListToString(output));
    }
}