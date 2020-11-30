package net.chriswareham.alesisv25;

public class Pad {

    private PadMode mode = PadMode.NOTE;

    // 1 -16
    private int midiChannel = 1;

    //
    // NOTE
    //

    // 0 - 127
    private int note;

    // 0 - 127
    private int velocity;

    // 1 - 8
    private int curve;

    //
    // CC_TOGGLE / CC_MOMENTARY
    //

    // 0 - 127
    private int cc;

    //
    // CC_TOGGLE
    //

    // 0 - 127
    private int toggleOn;

    // 0 - 127
    private int toggleOff;

    //
    // CC_MOMENTARY
    //

    // 0 - 127
    private int pressed;

    // 0 - 127
    private int released;

    //
    // PROGRAM_CHANGE
    //

    // 0 - 127
    private int bankLsb;

    // 0 - 127
    private int bankMsb;

    // 0 - 127
    private int program;

    public PadMode getMode() {
        return mode;
    }

    public void setMode(final PadMode mode) {
        this.mode = mode;
    }

    public int getMidiChannel() {
        return midiChannel;
    }

    public void setMidiChannel(final int midiChannel) {
        this.midiChannel = midiChannel;
    }

    public int getNote() {
        return note;
    }

    public void setNote(final int note) {
        this.note = note;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(final int velocity) {
        this.velocity = velocity;
    }

    public int getCurve() {
        return curve;
    }

    public void setCurve(final int curve) {
        this.curve = curve;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(final int cc) {
        this.cc = cc;
    }

    public int getToggleOn() {
        return toggleOn;
    }

    public void setToggleOn(final int toggleOn) {
        this.toggleOn = toggleOn;
    }

    public int getToggleOff() {
        return toggleOff;
    }

    public void setToggleOff(final int toggleOff) {
        this.toggleOff = toggleOff;
    }

    public int getPressed() {
        return pressed;
    }

    public void setPressed(final int pressed) {
        this.pressed = pressed;
    }

    public int getReleased() {
        return released;
    }

    public void setReleased(final int released) {
        this.released = released;
    }

    public int getBankLsb() {
        return bankLsb;
    }

    public void setBankLsb(final int bankLsb) {
        this.bankLsb = bankLsb;
    }

    public int getBankMsb() {
        return bankMsb;
    }

    public void setBankMsb(final int bankMsb) {
        this.bankMsb = bankMsb;
    }

    public int getProgram() {
        return program;
    }

    public void setProgram(final int program) {
        this.program = program;
    }
}
