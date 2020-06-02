package lab_5;
import java.util.Arrays;

public class Sentence {

    private static final String PUNCTUATION_SYMBOLS = ",.!?";
    private SentenceMember[] sentenceMembers;
    private Word[] words;

    public Sentence(String s) {
        int w_am = 0;

        //String[] split = s.split("(?=,|\\.|!|\\?)|\\s");
        String[] split = s.split("(?=[,.!?])|\\s");

        sentenceMembers = new SentenceMember[split.length];
        for (int i = 0; i < split.length; i++) {
            if (PUNCTUATION_SYMBOLS.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);
            } else {
                sentenceMembers[i] = new Word(split[i]);
                w_am += 1;
            }
        }

        words = new Word[w_am];
        int ind_w = 0;

        for (String value : split) {
            if (!PUNCTUATION_SYMBOLS.contains(value)) {
                words[ind_w] = new Word(value);
                ind_w += 1;
            }
        }
    }

    public void delWord(int i) {
        int pos = 0;
        int in_mem = Arrays.asList(sentenceMembers).indexOf(words[i]);
        SentenceMember[] sentenceMembers_for_ = sentenceMembers;
        Word[] words_for_ = words;
        sentenceMembers = new SentenceMember[sentenceMembers_for_.length-1];
        words = new Word[words_for_.length-1];
        for (SentenceMember j: sentenceMembers_for_) {
            if (sentenceMembers_for_[in_mem]!=j) {
                sentenceMembers[pos] = j;
                pos += 1;
            }
        }
        pos = 0;
        for (Word j: words_for_) {
            if (words_for_[i]!=j) {
                words[pos] = j;
                pos += 1;
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
