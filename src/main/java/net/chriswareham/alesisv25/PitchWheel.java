package net.chriswareham.alesisv25;

public class PitchWheel {

    // 1 -16
    private int midiChannel = 1;

    public int getMidiChannel() {
        return midiChannel;
    }

    public void setMidiChannel(final int midiChannel) {
        this.midiChannel = midiChannel;
    }
}
