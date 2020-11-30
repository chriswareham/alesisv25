package net.chriswareham.alesisv25;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;

public class ButtonPanel extends GridBagPanel {

    private final DefaultComboBoxModel<ButtonMode> modeModel = new DefaultComboBoxModel<>();

    private final JComboBox<ButtonMode> modeComboBox = new JComboBox<>(modeModel);

    private final SpinnerNumberModel midiChannelModel = new SpinnerNumberModel(1, 1, 16, 1);

    private final JSpinner midiChannelSpinner = new JSpinner(midiChannelModel);

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

    private final Button button;

    public ButtonPanel(final Button button) {
        this.button = button;
        createInterface();
    }

    private void createInterface() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        createComponents();
        addComponents();
    }

    private void createComponents() {
        ButtonMode mode = button.getMode();

        modeModel.addRows(ButtonMode.values());
        modeModel.setSelectedRow(mode);
        modeComboBox.addActionListener(event -> updateMode());

        midiChannelModel.setValue(button.getMidiChannel());
        midiChannelSpinner.addChangeListener(event -> updateMidiChannel());

        ccModel.setValue(button.getCc());
        ccSpinner.addChangeListener(event -> updateCc());
        ccSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE || mode == ButtonMode.CC_MOMENTARY);

        toggleOnModel.setValue(button.getToggleOn());
        toggleOnSpinner.addChangeListener(event -> updateToggleOn());
        toggleOnSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE);

        toggleOffModel.setValue(button.getToggleOff());
        toggleOffSpinner.addChangeListener(event -> updateToggleOff());
        toggleOffSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE);

        pressedModel.setValue(button.getPressed());
        pressedSpinner.addChangeListener(event -> updatePressed());
        pressedSpinner.setEnabled(mode == ButtonMode.CC_MOMENTARY);

        releasedModel.setValue(button.getReleased());
        releasedSpinner.addChangeListener(event -> updateReleased());
        releasedSpinner.setEnabled(mode == ButtonMode.CC_MOMENTARY);

        bankLsbModel.setValue(button.getBankLsb());
        bankLsbSpinner.addChangeListener(event -> updateBankLsb());
        bankLsbSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);

        bankMsbModel.setValue(button.getBankMsb());
        bankMsbSpinner.addChangeListener(event -> updateBankMsb());
        bankMsbSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);

        programModel.setValue(button.getProgram());
        programSpinner.addChangeListener(event -> updateProgram());
        programSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);
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
        ButtonMode mode = modeModel.getSelectedRow();

        button.setMode(mode);

        ccSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE || mode == ButtonMode.CC_MOMENTARY);

        toggleOnSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE);
        toggleOffSpinner.setEnabled(mode == ButtonMode.CC_TOGGLE);

        pressedSpinner.setEnabled(mode == ButtonMode.CC_MOMENTARY);
        releasedSpinner.setEnabled(mode == ButtonMode.CC_MOMENTARY);

        bankLsbSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);
        bankMsbSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);
        programSpinner.setEnabled(mode == ButtonMode.PROGRAM_CHANGE);
    }

    private void updateMidiChannel() {
        button.setMidiChannel(midiChannelModel.getNumber().intValue());
    }

    private void updateCc() {
        button.setCc(ccModel.getNumber().intValue());
    }

    private void updateToggleOn() {
        button.setToggleOn(toggleOnModel.getNumber().intValue());
    }

    private void updateToggleOff() {
        button.setToggleOff(toggleOffModel.getNumber().intValue());
    }

    private void updatePressed() {
        button.setPressed(pressedModel.getNumber().intValue());
    }

    private void updateReleased() {
        button.setReleased(releasedModel.getNumber().intValue());
    }

    private void updateBankLsb() {
        button.setBankLsb(bankLsbModel.getNumber().intValue());
    }

    private void updateBankMsb() {
        button.setBankMsb(bankMsbModel.getNumber().intValue());
    }

    private void updateProgram() {
        button.setProgram(programModel.getNumber().intValue());
    }
}
