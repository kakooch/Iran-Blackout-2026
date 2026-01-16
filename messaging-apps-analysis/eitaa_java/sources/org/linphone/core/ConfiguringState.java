package org.linphone.core;

/* loaded from: classes3.dex */
public enum ConfiguringState {
    Successful(0),
    Failed(1),
    Skipped(2);

    protected final int mValue;

    ConfiguringState(int i) {
        this.mValue = i;
    }

    public static ConfiguringState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Successful;
        }
        if (i == 1) {
            return Failed;
        }
        if (i == 2) {
            return Skipped;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ConfiguringState");
    }

    protected static ConfiguringState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ConfiguringState[] configuringStateArr = new ConfiguringState[length];
        for (int i = 0; i < length; i++) {
            configuringStateArr[i] = fromInt(iArr[i]);
        }
        return configuringStateArr;
    }

    protected static int[] toIntArray(ConfiguringState[] configuringStateArr) throws RuntimeException {
        int length = configuringStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = configuringStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
