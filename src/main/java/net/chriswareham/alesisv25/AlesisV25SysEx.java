package net.chriswareham.alesisv25;

import java.util.ArrayList;
import java.util.List;

public class AlesisV25SysEx {

    private static final byte UPDATE = (byte) 0x61;

    private static final byte QUERY = (byte) 0x62;

    private static final byte REPLY = (byte) 0x63;

    private static final List<Byte> HEADER_START = List.of((byte) 0x00, (byte) 0x00, (byte) 0x0e, (byte) 0x00, (byte) 0x41);

    private static final List<Byte> HEADER_END = List.of((byte) 0x00, (byte) 0x5d);

    private static final byte SYSEX_START = (byte) 0xf0;

    private static final byte SYSEX_END = (byte) 0xf7;

    public void query() {
        List<Byte> message = new ArrayList<>();
        message.add(SYSEX_START);
        message.addAll(HEADER_START);
        message.add(QUERY);
        message.addAll(HEADER_END);
        message.add(SYSEX_END);
    }

    public void update(final Preset preset) {
        List<Byte> message = new ArrayList<>();
        message.add(SYSEX_START);
        message.addAll(HEADER_START);
        message.add(UPDATE);
        message.addAll(HEADER_END);
        message.addAll(preset.serialise());
        message.add(SYSEX_END);
    }

    public void reply(final Preset preset) {
        List<Byte> message = new ArrayList<>();
        message.add(SYSEX_START);
        message.addAll(HEADER_START);
        message.add(REPLY);
        message.addAll(HEADER_END);
        message.addAll(preset.serialise());
        message.add(SYSEX_END);
    }
}
