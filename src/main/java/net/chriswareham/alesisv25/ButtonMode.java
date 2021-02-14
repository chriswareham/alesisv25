package net.chriswareham.alesisv25;

public enum ButtonMode {

    CC_TOGGLE("CC Toggle"),

    CC_MOMENTARY("CC Momentary"),

    PROGRAM_CHANGE("Program Change");

    private final String description;

    ButtonMode(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
