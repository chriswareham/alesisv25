package net.chriswareham.alesisv25;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import net.chriswareham.gui.AbstractFrame;
import net.chriswareham.gui.GridBagPanel;
import net.chriswareham.gui.MenuUtils;

public class ConfigurationTool extends AbstractFrame {

    public static void main(final String... args) {
        new ConfigurationTool().open();
    }

    private final Preset preset = new Preset();

    public ConfigurationTool() {
        super("Alesis V25 Configuration Tool");
    }

    @Override
    protected void createInterface() {
        addWindowClosedListener(event -> System.exit(0));

        setJMenuBar(createMenuBar());

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Knobs", createKnobsTab());
        tabbedPane.addTab("Buttons", createButtonsTab());
        tabbedPane.addTab("Pads 1-4", createPadsTab1());
        tabbedPane.addTab("Pads 5-8", createPadsTab2());
        tabbedPane.addTab("Key Bed", createKeyBedTab());
        tabbedPane.addTab("Wheels", createWheelsTab());
        tabbedPane.addTab("Sustain", createSustainTab());

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    @Override
    protected void populateInterface() {

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = menuBar.add(MenuUtils.createMenu("File", "F", "File"));

        menu.add(MenuUtils.createMenuItem("Device", "D", "Device", event -> device()));

        menu.addSeparator();

        menu.add(MenuUtils.createMenuItem("Receive Preset", "R", "Receive preset", event -> receivePreset()));

        menu.add(MenuUtils.createMenuItem("Transmit Preset", "T", "Transmit preset", event -> transmitPreset()));

        menu.addSeparator();

        menu.add(MenuUtils.createMenuItem("Load Preset", "L", "Load preset", event -> loadPreset()));

        menu.add(MenuUtils.createMenuItem("Save Preset", "S", "Save preset", event -> savePreset()));

        menu.addSeparator();

        menu.add(MenuUtils.createMenuItem("Exit", "X", "Exit", event -> close()));

        return menuBar;
    }

    private JPanel createKnobsTab() {
        return new GridBagPanel()
            .addCell(new JLabel("Knob 1", JLabel.CENTER), true)
            .addCell(new JLabel("Knob 2", JLabel.CENTER), true)
            .addCell(new JLabel("Knob 3", JLabel.CENTER), true)
            .addCell(new JLabel("Knob 4", JLabel.CENTER), true)
            .endRow()
            .addCell(new KnobPanel(preset.getKnobs().get(0)))
            .addCell(new KnobPanel(preset.getKnobs().get(1)))
            .addCell(new KnobPanel(preset.getKnobs().get(2)))
            .addCell(new KnobPanel(preset.getKnobs().get(3)))
            .endRow()
            .addExpandingRow();
    }

    private JPanel createButtonsTab() {
        return new GridBagPanel()
            .addCell(new JLabel("Button 1", JLabel.CENTER), true)
            .addCell(new JLabel("Button 2", JLabel.CENTER), true)
            .addCell(new JLabel("Button 3", JLabel.CENTER), true)
            .addCell(new JLabel("Button 4", JLabel.CENTER), true)
            .endRow()
            .addCell(new ButtonPanel(preset.getButtons().get(0)))
            .addCell(new ButtonPanel(preset.getButtons().get(1)))
            .addCell(new ButtonPanel(preset.getButtons().get(2)))
            .addCell(new ButtonPanel(preset.getButtons().get(3)))
            .endRow()
            .addExpandingRow();
    }

    private JPanel createPadsTab1() {
        return new GridBagPanel()
            .addCell(new JLabel("Pad 1", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 2", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 3", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 4", JLabel.CENTER), true)
            .endRow()
            .addCell(new PadPanel(preset.getPads().get(0)))
            .addCell(new PadPanel(preset.getPads().get(1)))
            .addCell(new PadPanel(preset.getPads().get(2)))
            .addCell(new PadPanel(preset.getPads().get(3)))
            .endRow()
            .addExpandingRow();
    }

    private JPanel createPadsTab2() {
        return new GridBagPanel()
            .addCell(new JLabel("Pad 5", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 6", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 7", JLabel.CENTER), true)
            .addCell(new JLabel("Pad 8", JLabel.CENTER), true)
            .endRow()
            .addCell(new PadPanel(preset.getPads().get(4)))
            .addCell(new PadPanel(preset.getPads().get(5)))
            .addCell(new PadPanel(preset.getPads().get(6)))
            .addCell(new PadPanel(preset.getPads().get(7)))
            .endRow()
            .addExpandingRow();
    }

    private JPanel createKeyBedTab() {
        return new GridBagPanel()
            .addCell(new KeyBedPanel(preset.getKeyBed()))
            .addCell(true)
            .addCell(true)
            .addCell(true)
            .endRow()
            .addExpandingRow();
    }

    private JPanel createWheelsTab() {
        return new GridBagPanel()
            .addCell(new JLabel("Pitch Wheel", JLabel.CENTER), true)
            .addCell(new JLabel("Mod Wheel", JLabel.CENTER), true)
            .addCell(true)
            .addCell(true)
            .endRow()
            .addCell(new PitchWheelPanel(preset.getPitchWheel()))
            .addCell(new ModWheelPanel(preset.getModWheel()))
            .addCell(true)
            .addCell(true)
            .endRow()
            .addExpandingRow();
    }

    private JPanel createSustainTab() {
        return new GridBagPanel()
            .addCell(new SustainPanel(preset.getSustain()))
            .addCell(true)
            .addCell(true)
            .addCell(true)
            .endRow()
            .addExpandingRow();
    }

    private void receivePreset() {
        // XXX
    }

    private void transmitPreset() {
        // XXX
    }

    private void loadPreset() {
        // XXX
    }

    private void savePreset() {
        // XXX
    }

    private void device() {
        // XXX
    }
}
