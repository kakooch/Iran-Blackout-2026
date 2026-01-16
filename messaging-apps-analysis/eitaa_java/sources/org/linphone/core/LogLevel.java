package org.linphone.core;

/* loaded from: classes3.dex */
public enum LogLevel {
    Debug(1),
    Trace(2),
    Message(4),
    Warning(8),
    Error(16),
    Fatal(32);

    protected final int mValue;

    LogLevel(int i) {
        this.mValue = i;
    }

    public static LogLevel fromInt(int i) throws RuntimeException {
        if (i == 1) {
            return Debug;
        }
        if (i == 2) {
            return Trace;
        }
        if (i == 4) {
            return Message;
        }
        if (i == 8) {
            return Warning;
        }
        if (i == 16) {
            return Error;
        }
        if (i == 32) {
            return Fatal;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LogLevel");
    }

    protected static LogLevel[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LogLevel[] logLevelArr = new LogLevel[length];
        for (int i = 0; i < length; i++) {
            logLevelArr[i] = fromInt(iArr[i]);
        }
        return logLevelArr;
    }

    protected static int[] toIntArray(LogLevel[] logLevelArr) throws RuntimeException {
        int length = logLevelArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = logLevelArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
