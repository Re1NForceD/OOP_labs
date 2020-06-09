package lab_5;

public class Main {
    public static void main(String[] args) {
        char firstChar = 'a';
        char lastChar = 'a';
        Text text = new Text("At ataaata matar atata. Mara atata atat tatr ata at. Tamar ata ratar atataa.");
        for (Sentence sen: text.getSentences()) {
            int ind = -1;
            for (int w=0; w<sen.getWords().length; w++) {
                Letter[] charsOfWord = sen.getWords()[w].getLetters();
                if (Character.toLowerCase(charsOfWord[0].getaChar())==firstChar && charsOfWord[charsOfWord.length-1].getaChar()==lastChar) {
                    if (ind==-1) {
                        ind = w;
                    }
                    else if (sen.getWords()[w].getLetters().length>sen.getWords()[ind].getLetters().length) {
                        ind = w;
                    }
                }
            }
            if (ind!=-1){
                sen.delWord(ind);
            }
        }
        System.out.println(text);
        System.out.println("Done :)");
    }
}
