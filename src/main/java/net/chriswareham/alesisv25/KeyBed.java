package net.chriswareham.alesisv25;

public class KeyBed {

    // 1 - 16
    private int midiChannel = 1;

    // -12 - 12
    private int transpose;

    // 0 - 9
    private int octave = 4;

    // 1 - 8
    private int curve = 4;

    public int getMidiChannel() {
        return midiChannel;
    }

    public void setMidiChannel(final int midiChannel) {
        this.midiChannel = midiChannel;
    }

    public int getTranspose() {
        return transpose;
    }

    public void setTranspose(final int transpose) {
        this.transpose = transpose;
    }

    public int getOctave() {
        return octave;
    }

    public void setOctave(final int octave) {
        this.octave = octave;
    }

    public int getCurve() {
        return curve;
    }

    public void setCurve(final int curve) {
        this.curve = curve;
    }
}
