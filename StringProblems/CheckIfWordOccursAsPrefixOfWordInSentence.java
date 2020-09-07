package StringProblems;

public class CheckIfWordOccursAsPrefixOfWordInSentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        int iter = 0;
        for (String word : words) {
            iter++;
            if (word.indexOf(searchWord) == 0) {
                return iter;
            }
        }
        return -1;
    }
}
