package net.chriswareham.alesisv25;

import java.util.List;

public class Preset {

    private final List<Knob> knobs = List.of(
        new Knob(),
        new Knob(),
        new Knob(),
        new Knob()
    );

    private final List<Button> buttons = List.of(
        new Button(),
        new Button(),
        new Button(),
        new Button()
    );

    private final List<Pad> pads = List.of(
        new Pad(),
        new Pad(),
        new Pad(),
        new Pad(),
        new Pad(),
        new Pad(),
        new Pad(),
        new Pad()
    );

    private final KeyBed keyBed = new KeyBed();

    private final ModWheel modWheel = new ModWheel();

    private final PitchWheel pitchWheel = new PitchWheel();

    private final Sustain sustain = new Sustain();

    public List<Knob> getKnobs() {
        return knobs;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public List<Pad> getPads() {
        return pads;
    }

    public KeyBed getKeyBed() {
        return keyBed;
    }

    public ModWheel getModWheel() {
        return modWheel;
    }

    public PitchWheel getPitchWheel() {
        return pitchWheel;
    }

    public Sustain getSustain() {
        return sustain;
    }

    public List<Byte> serialise() {
        return List.of();
    }
}
