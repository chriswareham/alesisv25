package net.chriswareham.alesisv25;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.GridBagPanel;

public class SustainPanel extends GridBagPanel {

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

    private final SpinnerNumberModel ccModel = new SpinnerNumberModel(64, 1, 127, 1);

    private final JSpinner ccSpinner = new JSpinner(ccModel);

    private final SpinnerNumberModel minModel = new SpinnerNumberModel(0, 0, 127, 1);

    private final JSpinner minSpinner = new JSpinner(minModel);

    private final SpinnerNumberModel maxModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner maxSpinner = new JSpinner(maxModel);

    private final Sustain sustain;

    public SustainPanel(final Sustain sustain) {
        this.sustain = sustain;
        createInterface();
    }

    private void createInterface() {
        createComponents();
        addComponents();
    }

    private void createComponents() {
        midiChannelModel.setValue(sustain.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());

        ccModel.setValue(sustain.getCc());
        ccSpinner.addChangeListener(event -> updateCc());

        minModel.setValue(sustain.getMin());
        minSpinner.addChangeListener(event -> updateMin());

        maxModel.setValue(sustain.getMax());
        maxSpinner.addChangeListener(event -> updateMax());
    }

    private void addComponents() {
        addCell(new JLabel("MIDI Channel:"));
        addCell(midiChannelSpinner, true);
        endRow();

        addCell(new JLabel("CC:"));
        addCell(ccSpinner, true);
        endRow();

        addCell(new JLabel("Min:"));
        addCell(minSpinner, true);
        endRow();

        addCell(new JLabel("Max:"));
        addCell(maxSpinner, true);
        endRow();
    }

    private void updateMidiChannel() {
        sustain.setMidiChannel(midiChannelModel.getNumber().intValue());
    }

    private void updateCc() {
        sustain.setCc(ccModel.getNumber().intValue());
    }

    private void updateMin() {
        sustain.setMin(minModel.getNumber().intValue());
    }

    private void updateMax() {
        sustain.setMax(maxModel.getNumber().intValue());
    }
}
