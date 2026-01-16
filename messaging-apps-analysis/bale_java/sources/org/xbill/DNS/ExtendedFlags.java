package org.xbill.DNS;

/* loaded from: classes8.dex */
public final class ExtendedFlags {
    public static final int DO = 32768;
    private static final Mnemonic extflags;

    static {
        Mnemonic mnemonic = new Mnemonic("EDNS Flag", 3);
        extflags = mnemonic;
        mnemonic.setMaximum(65535);
        mnemonic.setPrefix("FLAG");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(32768, "do");
    }

    private ExtendedFlags() {
    }

    public static String string(int i) {
        return extflags.getText(i);
    }

    public static String stringFromBit(int i) {
        return extflags.getText(1 << (15 - i));
    }

    public static int value(String str) {
        return extflags.getValue(str);
    }
}
