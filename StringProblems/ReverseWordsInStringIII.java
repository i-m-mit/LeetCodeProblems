package StringProblems;

public class ReverseWordsInStringIII {
    public String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer();
        StringBuffer cBuffer;
        for (String cur : s.split(" ")) {
            cBuffer = new StringBuffer(cur);
            buffer.append(cBuffer.reverse() + " ");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        return buffer.toString();
    }
}