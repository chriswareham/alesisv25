package net.chriswareham.alesisv25;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;

public class PadPanel extends GridBagPanel {

    private final DefaultComboBoxModel<PadMode> modeModel = new DefaultComboBoxModel<>();

    private final JComboBox<PadMode> modeComboBox = new JComboBox<>(modeModel);

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

    private final SpinnerNumberModel noteModel = new SpinnerNumberModel(1, 1, 127, 1);

    private final JSpinner noteSpinner = new JSpinner(noteModel);

    private final SpinnerNumberModel velocityModel = new SpinnerNumberModel(1, 1, 127, 1);

    private final JSpinner velocitySpinner = new JSpinner(velocityModel);

    private final SpinnerNumberModel curveModel = new SpinnerNumberModel(1, 1, 8, 1);

    private final JSpinner curveSpinner = new JSpinner(curveModel);

    private final SpinnerNumberModel ccModel = new SpinnerNumberModel(1, 1, 127, 1);

    private final JSpinner ccSpinner = new JSpinner(ccModel);

    private final SpinnerNumberModel toggleOnModel = new SpinnerNumberModel(0, 0, 127, 1);

    private final JSpinner toggleOnSpinner = new JSpinner(toggleOnModel);

    private final SpinnerNumberModel toggleOffModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner toggleOffSpinner = new JSpinner(toggleOffModel);

    private final SpinnerNumberModel pressedModel = new SpinnerNumberModel(0, 0, 127, 1);

    private final JSpinner pressedSpinner = new JSpinner(pressedModel);

    private final SpinnerNumberModel releasedModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner releasedSpinner = new JSpinner(releasedModel);

    private final SpinnerNumberModel bankLsbModel = new SpinnerNumberModel(0, 0, 127, 1);

    private final JSpinner bankLsbSpinner = new JSpinner(bankLsbModel);

    private final SpinnerNumberModel bankMsbModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner bankMsbSpinner = new JSpinner(bankMsbModel);

    private final SpinnerNumberModel programModel = new SpinnerNumberModel(127, 0, 127, 1);

    private final JSpinner programSpinner = new JSpinner(programModel);

    private final Pad pad;

    public PadPanel(final Pad pad) {
        this.pad = pad;
        createInterface();
    }

    private void createInterface() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createComponents();
        addComponents();
    }

    private void createComponents() {
        PadMode mode = pad.getMode();

        modeModel.addRows(PadMode.values());
        modeModel.setSelectedRow(mode);
        modeComboBox.addActionListener(event -> updateMode());

        midiChannelModel.setValue(pad.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());

        noteModel.setValue(pad.getNote());
        noteSpinner.addChangeListener(event -> updateNote());
        noteSpinner.setEnabled(mode == PadMode.NOTE);

        velocityModel.setValue(pad.getVelocity());
        velocitySpinner.addChangeListener(event -> updateVelocity());
        velocitySpinner.setEnabled(mode == PadMode.NOTE);

        curveModel.setValue(pad.getCurve());
        curveSpinner.addChangeListener(event -> updateCurve());
        curveSpinner.setEnabled(mode == PadMode.NOTE);

        ccModel.setValue(pad.getCc());
        ccSpinner.addChangeListener(event -> updateCc());
        ccSpinner.setEnabled(mode == PadMode.CC_TOGGLE || mode == PadMode.CC_MOMENTARY);

        toggleOnModel.setValue(pad.getToggleOn());
        toggleOnSpinner.addChangeListener(event -> updateToggleOn());
        toggleOnSpinner.setEnabled(mode == PadMode.CC_TOGGLE);

        toggleOffModel.setValue(pad.getToggleOff());
        toggleOffSpinner.addChangeListener(event -> updateToggleOff());
        toggleOffSpinner.setEnabled(mode == PadMode.CC_TOGGLE);

        pressedModel.setValue(pad.getPressed());
        pressedSpinner.addChangeListener(event -> updatePressed());
        pressedSpinner.setEnabled(mode == PadMode.CC_MOMENTARY);

        releasedModel.setValue(pad.getReleased());
        releasedSpinner.addChangeListener(event -> updateReleased());
        releasedSpinner.setEnabled(mode == PadMode.CC_MOMENTARY);

        bankLsbModel.setValue(pad.getBankLsb());
        bankLsbSpinner.addChangeListener(event -> updateBankLsb());
        bankLsbSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);

        bankMsbModel.setValue(pad.getBankMsb());
        bankMsbSpinner.addChangeListener(event -> updateBankMsb());
        bankMsbSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);

        programModel.setValue(pad.getProgram());
        programSpinner.addChangeListener(event -> updateProgram());
        programSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);
    }

    private void addComponents() {
        addCell(new JLabel("Mode:"));
        addCell(modeComboBox, true);
        endRow();

        addCell(new JLabel("MIDI Channel:"));
        addCell(midiChannelSpinner, true);
        endRow();

        addCell(new JLabel("Note:"));
        addCell(noteSpinner, true);
        endRow();

        addCell(new JLabel("Velocity:"));
        addCell(velocitySpinner, true);
        endRow();

        addCell(new JLabel("Curve:"));
        addCell(curveSpinner, true);
        endRow();

        addCell(new JLabel("CC:"));
        addCell(ccSpinner, true);
        endRow();

        addCell(new JLabel("Toggle On:"));
        addCell(toggleOnSpinner, true);
        endRow();

        addCell(new JLabel("Toggle Off:"));
        addCell(toggleOffSpinner, true);
        endRow();

        addCell(new JLabel("Pressed:"));
        addCell(pressedSpinner, true);
        endRow();

        addCell(new JLabel("Released:"));
        addCell(releasedSpinner, true);
        endRow();

        addCell(new JLabel("Bank LSB:"));
        addCell(bankLsbSpinner, true);
        endRow();

        addCell(new JLabel("Bank MSB:"));
        addCell(bankMsbSpinner, true);
        endRow();

        addCell(new JLabel("Program:"));
        addCell(programSpinner, true);
        endRow();
    }

    private void updateMode() {
        PadMode mode = modeModel.getSelectedRow();

        pad.setMode(mode);

        ccSpinner.setEnabled(mode == PadMode.CC_TOGGLE || mode == PadMode.CC_MOMENTARY);

        noteSpinner.setEnabled(mode == PadMode.NOTE);
        velocitySpinner.setEnabled(mode == PadMode.NOTE);
        curveSpinner.setEnabled(mode == PadMode.NOTE);

        toggleOnSpinner.setEnabled(mode == PadMode.CC_TOGGLE);
        toggleOffSpinner.setEnabled(mode == PadMode.CC_TOGGLE);

        pressedSpinner.setEnabled(mode == PadMode.CC_MOMENTARY);
        releasedSpinner.setEnabled(mode == PadMode.CC_MOMENTARY);

        bankLsbSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);
        bankMsbSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);
        programSpinner.setEnabled(mode == PadMode.PROGRAM_CHANGE);
    }

    private void updateMidiChannel() {
        pad.setMidiChannel(midiChannelModel.getNumber().intValue());
    }

    private void updateNote() {
        pad.setNote(noteModel.getNumber().intValue());
    }

    private void updateVelocity() {
        pad.setVelocity(velocityModel.getNumber().intValue());
    }

    private void updateCurve() {
        pad.setCurve(curveModel.getNumber().intValue());
    }

    private void updateCc() {
        pad.setCc(ccModel.getNumber().intValue());
    }

    private void updateToggleOn() {
        pad.setToggleOn(toggleOnModel.getNumber().intValue());
    }

    private void updateToggleOff() {
        pad.setToggleOff(toggleOffModel.getNumber().intValue());
    }

    private void updatePressed() {
        pad.setPressed(pressedModel.getNumber().intValue());
    }

    private void updateReleased() {
        pad.setReleased(releasedModel.getNumber().intValue());
    }

    private void updateBankLsb() {
        pad.setBankLsb(bankLsbModel.getNumber().intValue());
    }

    private void updateBankMsb() {
        pad.setBankMsb(bankMsbModel.getNumber().intValue());
    }

    private void updateProgram() {
        pad.setProgram(programModel.getNumber().intValue());
    }
}
