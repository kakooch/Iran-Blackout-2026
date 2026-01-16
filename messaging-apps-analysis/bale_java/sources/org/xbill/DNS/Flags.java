package org.xbill.DNS;

/* loaded from: classes8.dex */
public final class Flags {
    public static final byte AA = 5;
    public static final byte AD = 10;
    public static final byte CD = 11;
    public static final int DO = 32768;
    private static final Mnemonic HEADER_FLAGS;
    public static final byte QR = 0;
    public static final byte RA = 8;
    public static final byte RD = 7;
    public static final byte TC = 6;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Header Flag", 3);
        HEADER_FLAGS = mnemonic;
        mnemonic.setMaximum(15);
        mnemonic.setPrefix("FLAG");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "qr");
        mnemonic.add(5, "aa");
        mnemonic.add(6, "tc");
        mnemonic.add(7, "rd");
        mnemonic.add(8, "ra");
        mnemonic.add(10, "ad");
        mnemonic.add(11, "cd");
    }

    private Flags() {
    }

    public static boolean isFlag(int i) {
        HEADER_FLAGS.check(i);
        return (i < 1 || i > 4) && i < 12;
    }

    public static String string(int i) {
        return HEADER_FLAGS.getText(i);
    }

    public static int value(String str) {
        return HEADER_FLAGS.getValue(str);
    }
}
