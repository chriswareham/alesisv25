package net.chriswareham.alesisv25;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;

public class KnobPanel extends GridBagPanel {

    private final DefaultComboBoxModel<KnobMode> modeModel = new DefaultComboBoxModel<>();

    private final JComboBox<KnobMode> modeComboBox = new JComboBox<>(modeModel);

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

    private final SpinnerNumberModel ccModel = new SpinnerNumberModel(1, 1, 127, 1);

    private final JSpinner ccSpinner = new JSpinner(ccModel);

    private final SpinnerNumberModel minModel = new SpinnerNumberModel(0, 0, 127, 1);

    private final JSpinner minSpinner = new JSpinner(minModel);

    private final SpinnerNumberModel maxModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner maxSpinner = new JSpinner(maxModel);

    private final Knob knob;

    public KnobPanel(final Knob knob) {
        this.knob = knob;
        createInterface();
    }

    private void createInterface() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createComponents();
        addComponents();
    }

    private void createComponents() {
        KnobMode mode = knob.getMode();

        modeModel.addRows(KnobMode.values());
        modeModel.setSelectedRow(mode);
        modeComboBox.addActionListener(event -> updateMode());

        midiChannelModel.setValue(knob.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());

        ccModel.setValue(knob.getCc());
        ccSpinner.addChangeListener(event -> updateCc());
        ccSpinner.setEnabled(mode == KnobMode.CC);

        minModel.setValue(knob.getMin());
        minSpinner.addChangeListener(event -> updateMin());

        maxModel.setValue(knob.getMax());
        maxSpinner.addChangeListener(event -> updateMax());
    }

    private void addComponents() {
        addCell(new JLabel("Mode:"));
        addCell(modeComboBox, true);
        endRow();

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

    private void updateMode() {
        KnobMode mode = modeModel.getSelectedRow();

        knob.setMode(mode);

        ccSpinner.setEnabled(mode == KnobMode.CC);
    }

    private void updateMidiChannel() {
        knob.setMidiChannel(midiChannelModel.getNumber().intValue());
    }

    private void updateCc() {
        knob.setCc(ccModel.getNumber().intValue());
    }

    private void updateMin() {
        knob.setMin(minModel.getNumber().intValue());
    }

    private void updateMax() {
        knob.setMax(maxModel.getNumber().intValue());
    }
}
