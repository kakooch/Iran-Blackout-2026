package org.linphone.core;

/* loaded from: classes3.dex */
public enum GlobalState {
    Off(0),
    Startup(1),
    On(2),
    Shutdown(3),
    Configuring(4),
    Ready(5);

    protected final int mValue;

    GlobalState(int i) {
        this.mValue = i;
    }

    public static GlobalState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Off;
        }
        if (i == 1) {
            return Startup;
        }
        if (i == 2) {
            return On;
        }
        if (i == 3) {
            return Shutdown;
        }
        if (i == 4) {
            return Configuring;
        }
        if (i == 5) {
            return Ready;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for GlobalState");
    }

    protected static GlobalState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        GlobalState[] globalStateArr = new GlobalState[length];
        for (int i = 0; i < length; i++) {
            globalStateArr[i] = fromInt(iArr[i]);
        }
        return globalStateArr;
    }

    protected static int[] toIntArray(GlobalState[] globalStateArr) throws RuntimeException {
        int length = globalStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = globalStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
