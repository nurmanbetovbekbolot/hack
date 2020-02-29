package model;

public enum State {
    X('\uD83D', '\uDE0A'),
    O('\uD83D', '\uDE20'),
    c('.');

    Character firstChar;
    Character secondChar;

    State(Character firstChar) {
        this.firstChar = firstChar;
    }

    State(Character firstChar, Character secondChar) {
        this.firstChar = firstChar;
        this.secondChar = secondChar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.firstChar != null) {
            sb.append(this.firstChar);
        }
        if (this.secondChar != null) {
            sb.append(this.secondChar);
        }

        return sb.toString();
    }

}

