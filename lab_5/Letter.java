package lab_5;

public class Letter {

    private char aChar;

    public Letter(char aChar) {
        this.aChar = aChar;
    }

    public char getaChar() {
        return aChar;
    }

    @Override
    public String toString() {
        return Character.toString(aChar);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Letter) {
            return ((Letter)obj).aChar == aChar;
        }
        return false;
    }
}
