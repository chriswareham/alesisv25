package net.chriswareham.alesisv25;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.GridBagPanel;

public class KeyBedPanel extends GridBagPanel {

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

    private final SpinnerNumberModel transposeModel = new SpinnerNumberModel(0, -12, 12, 1);

    private final JSpinner transposeSpinner = new JSpinner(transposeModel);

    private final SpinnerNumberModel octaveModel = new SpinnerNumberModel(4, 0, 9, 1);

    private final JSpinner octaveSpinner = new JSpinner(octaveModel);

    private final SpinnerNumberModel curveModel = new SpinnerNumberModel(4, 1, 8, 1);

    private final JSpinner curveSpinner = new JSpinner(curveModel);

    private final KeyBed keyBed;

    public KeyBedPanel(final KeyBed keyBed) {
        this.keyBed = keyBed;
        createInterface();
    }

    private void createInterface() {
        createComponents();
        addComponents();
    }

    private void createComponents() {
        midiChannelModel.setValue(keyBed.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());

        transposeModel.setValue(keyBed.getTranspose());
        transposeSpinner.addChangeListener(event -> updateTranspose());

        octaveModel.setValue(keyBed.getOctave());
        octaveSpinner.addChangeListener(event -> updateOctave());

        curveModel.setValue(keyBed.getCurve());
        curveSpinner.addChangeListener(event -> updateCurve());
    }

    private void addComponents() {
        addCell(new JLabel("MIDI Channel:"));
        addCell(midiChannelSpinner, true);
        endRow();

        addCell(new JLabel("Transpose:"));
        addCell(transposeSpinner, true);
        endRow();

        addCell(new JLabel("Octave:"));
        addCell(octaveSpinner, true);
        endRow();

        addCell(new JLabel("Curve:"));
        addCell(curveSpinner, true);
        endRow();
    }

    private void updateMidiChannel() {
        keyBed.setMidiChannel(midiChannelModel.getNumber().intValue());
    }

    private void updateTranspose() {
        keyBed.setTranspose(transposeModel.getNumber().intValue());
    }

    private void updateOctave() {
        keyBed.setOctave(octaveModel.getNumber().intValue());
    }

    private void updateCurve() {
        keyBed.setCurve(curveModel.getNumber().intValue());
    }
}
