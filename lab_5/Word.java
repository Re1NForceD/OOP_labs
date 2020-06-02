package lab_5;

public class Word extends SentenceMember{

    private Letter[] letters;

    public Word(String s) {
        letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++) {
            letters[i] = new Letter(s.charAt(i));
        }
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString(){
        StringBuilder part = new StringBuilder();
        for (Letter i: letters) {
            part.append(i.toString());
        }
        return part.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Word) {
            Word word = (Word) obj;
            if (letters.length == word.letters.length) {
                for (int i = 0; i < letters.length; i++) {
                    if (!letters[i].equals(word.letters[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
