package lab_5;
import java.util.Arrays;

public class Sentence {

    private static final String PUNCTUATION_SYMBOLS = ",.!?";
    private SentenceMember[] sentenceMembers;
    private Word[] words;

    public Sentence(String s) {
        int wordAmount = 0;

        //String[] split = s.split("(?=,|\\.|!|\\?)|\\s");
        String[] split = s.split("(?=[,.!?])|\\s");

        sentenceMembers = new SentenceMember[split.length];
        for (int i = 0; i < split.length; i++) {
            if (PUNCTUATION_SYMBOLS.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);
            } else {
                sentenceMembers[i] = new Word(split[i]);
                wordAmount += 1;
            }
        }

        words = new Word[wordAmount];
        int wordsIndex = 0;

        for (String value : split) {
            if (!PUNCTUATION_SYMBOLS.contains(value)) {
                words[wordsIndex++] = new Word(value);
            }
        }
    }

    public void delWord(int i) {
        int position = 0;
        int toDelete = Arrays.asList(sentenceMembers).indexOf(words[i]);
        SentenceMember[] sentenceMembersCopy = sentenceMembers;
        Word[] wordsCopy = words;
        sentenceMembers = new SentenceMember[sentenceMembersCopy.length-1];
        words = new Word[wordsCopy.length-1];
        for (SentenceMember j: sentenceMembersCopy) {
            if (sentenceMembersCopy[toDelete]!=j) {
                sentenceMembers[position++] = j;
            }
        }
        position = 0;
        for (Word j: wordsCopy) {
            if (wordsCopy[i]!=j) {
                words[position++] = j;
            }
        }
    }

    public Word[] getWords() {
        return words;
    }

    public SentenceMember[] getSentenceMembers() {
        return sentenceMembers;
    }
}
