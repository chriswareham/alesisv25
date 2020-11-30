package net.chriswareham.alesisv25;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.GridBagPanel;

public class PitchWheelPanel extends GridBagPanel {

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

    private final PitchWheel pitchWheel;

    public PitchWheelPanel(final PitchWheel pitchWheel) {
        this.pitchWheel = pitchWheel;
        createInterface();
    }

    private void createInterface() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createComponents();
        addComponents();
    }

    private void createComponents() {
        midiChannelModel.setValue(pitchWheel.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());
    }

    private void addComponents() {
        addCell(new JLabel("MIDI Channel:"));
        addCell(midiChannelSpinner, true);
        endRow();
    }

    private void updateMidiChannel() {
        pitchWheel.setMidiChannel(midiChannelModel.getNumber().intValue());
    }
}
