package StringProblems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    Map<Character, Integer> map;

    public RomanToInteger() {
        map = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
    }

    public int romanToInt(String s) {
        int ans = 0;
        int current = 0;
        int lastVal = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I': {
                    current = 1;
                }
                    break;
                case 'V': {
                    current = 5;
                }
                    break;
                case 'X': {
                    current = 10;
                }
                    break;
                case 'L': {
                    current = 50;
                }
                    break;
                case 'C': {
                    current = 100;
                }
                    break;
                case 'D': {
                    current = 500;
                }
                    break;
                case 'M': {
                    current = 1000;
                }
                    break;
                default:
            }

            // current = map.get(s.charAt(i));
            if (lastVal != 0 && current < lastVal) {
                ans -= current;
            } else {
                ans += current;
            }
            lastVal = current;
        }

        return ans;
    }

    public static void main(String[] args) {
        RomanToInteger o = new RomanToInteger();
        System.out.println(o.romanToInt("MCMXCIV"));
    }
}