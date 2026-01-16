package org.linphone.core;

/* loaded from: classes3.dex */
public enum LogCollectionState {
    Disabled(0),
    Enabled(1),
    EnabledWithoutPreviousLogHandler(2);

    protected final int mValue;

    LogCollectionState(int i) {
        this.mValue = i;
    }

    public static LogCollectionState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Disabled;
        }
        if (i == 1) {
            return Enabled;
        }
        if (i == 2) {
            return EnabledWithoutPreviousLogHandler;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LogCollectionState");
    }

    protected static LogCollectionState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LogCollectionState[] logCollectionStateArr = new LogCollectionState[length];
        for (int i = 0; i < length; i++) {
            logCollectionStateArr[i] = fromInt(iArr[i]);
        }
        return logCollectionStateArr;
    }

    protected static int[] toIntArray(LogCollectionState[] logCollectionStateArr) throws RuntimeException {
        int length = logCollectionStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = logCollectionStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
