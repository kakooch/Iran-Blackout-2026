package org.linphone.core;

/* loaded from: classes3.dex */
public enum AVPFMode {
    Default(-1),
    Disabled(0),
    Enabled(1);

    protected final int mValue;

    AVPFMode(int i) {
        this.mValue = i;
    }

    public static AVPFMode fromInt(int i) throws RuntimeException {
        if (i == -1) {
            return Default;
        }
        if (i == 0) {
            return Disabled;
        }
        if (i == 1) {
            return Enabled;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for AVPFMode");
    }

    protected static AVPFMode[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        AVPFMode[] aVPFModeArr = new AVPFMode[length];
        for (int i = 0; i < length; i++) {
            aVPFModeArr[i] = fromInt(iArr[i]);
        }
        return aVPFModeArr;
    }

    protected static int[] toIntArray(AVPFMode[] aVPFModeArr) throws RuntimeException {
        int length = aVPFModeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = aVPFModeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
