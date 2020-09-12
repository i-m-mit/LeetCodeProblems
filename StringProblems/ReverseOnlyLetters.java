package StringProblems;

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        int first = 0;
        int last = S.length() - 1;
        char[] arr = S.toCharArray();
        char front, back;
        while (first <= last) {
            front = arr[first];
            back = arr[last];
            if (!Character.isLetter(front)) {
                first++;
            } else if (!Character.isLetter(back)) {
                last--;
            } else {
                arr[first++] = back;
                arr[last--] = front;
            }

        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters o = new ReverseOnlyLetters();

        System.out.println(o.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
