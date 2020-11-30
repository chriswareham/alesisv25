package net.chriswareham.alesisv25;

public class ModWheel {

    // 1 -16
    private int midiChannel = 1;

    // 0 - 127
    private int cc = 1;

    // 0 - 127
    private int min;

    // 0 - 127
    private int max = 127;

    public int getMidiChannel() {
        return midiChannel;
    }

    public void setMidiChannel(final int midiChannel) {
        this.midiChannel = midiChannel;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(final int cc) {
        this.cc = cc;
    }

    public int getMin() {
        return min;
    }

    public void setMin(final int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(final int max) {
        this.max = max;
    }
}
