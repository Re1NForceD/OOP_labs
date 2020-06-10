package lab_5;

public class Main {
    public static void main(String[] args) {
        char firstChar = 'a';
        char lastChar = 'a';
        Text text = new Text("At ataaata matar atata. Mara atata atat tatr ata at. Tamar ata ratar atataa.");
        for (Sentence sentence: text.getSentences()) {
            int index = -1;
            for (int i=0; i<sentence.getWords().length; i++) {
                Letter[] charsOfWord = sentence.getWords()[i].getLetters();
                if (Character.toLowerCase(charsOfWord[0].getaChar())==firstChar && charsOfWord[charsOfWord.length-1].getaChar()==lastChar) {
                    if (index==-1) {
                        index = i;
                    }
                    else if (sentence.getWords()[i].getLetters().length>sentence.getWords()[index].getLetters().length) {
                        index = i;
                    }
                }
            }
            if (index!=-1){
                sentence.delWord(index);
            }
        }
        System.out.println(text);
        System.out.println("Done :)");
    }
}
