package StringProblems;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        boolean capitalFound = false;
        int c;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (capitalFound) {
                if (Character.isLowerCase(c)) {
                    capitalFound = false;
                }
            } else {
                if (Character.isUpperCase(c)) {
                    if (i == 0) {
                        capitalFound = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
