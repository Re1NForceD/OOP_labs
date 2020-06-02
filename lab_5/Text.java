package lab_5;

public class Text {

    private Sentence[] sentences;

    public Text(String s) {
        String[] split = s.split("(?<=[?!.])");
        sentences = new Sentence[split.length];
        for (int i = 0; i < split.length; i++) {
            sentences[i] = new Sentence(split[i]);
        }
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder full = new StringBuilder();
        full.append(this.getSentences()[0].getSentenceMembers()[0].toString());
        for (Sentence s: this.getSentences()) {
            for (SentenceMember m: s.getSentenceMembers()) {
                if (m!=this.getSentences()[0].getSentenceMembers()[0]) {
                    if (m.getClass() == Word.class) {
                        full.append(" ").append(m.toString());
                    } else {
                        full.append(m.toString());
                    }
                }
            }
        }
        return full.toString();
    }
}
