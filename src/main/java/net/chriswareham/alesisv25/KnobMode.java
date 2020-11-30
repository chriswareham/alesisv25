package net.chriswareham.alesisv25;

public enum KnobMode {

    CC("CC"),

    AFTERTOUCH("Aftertouch");

    private final String description;

    KnobMode(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
