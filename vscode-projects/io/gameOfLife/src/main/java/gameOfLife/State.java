package gameOfLife;

/** Enumeration, type that allows only the two different values DEAD and ALIVE. */
public enum State {
    DEAD,
    ALIVE{
        /** To have circular state the last state changes to the first one. */
        @Override
        public State next() {
            return DEAD;
        }
    };

    /** Methode to go to the next state in order. */
    public State next() {
        return values()[ordinal() + 1];
    }
}
