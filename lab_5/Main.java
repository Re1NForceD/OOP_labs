package lab_5;

public class Main {
    public static void main(String[] args) {
        char first_char = 'a';
        char last_char = 'a';
        Text text = new Text("At ataaata matar atata. Mara atata atat tatr ata at. Tamar ata ratar atataa.");
        for (Sentence sen: text.getSentences()) {
            int ind = -1;
            for (int w=0; w<sen.getWords().length; w++) {
                Letter[] let_of_w = sen.getWords()[w].getLetters();
                if (Character.toLowerCase(let_of_w[0].getaChar())==first_char && let_of_w[let_of_w.length-1].getaChar()==last_char) {
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
