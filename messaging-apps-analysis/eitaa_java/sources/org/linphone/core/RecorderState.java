package org.linphone.core;

/* loaded from: classes3.dex */
public enum RecorderState {
    Closed(0),
    Paused(1),
    Running(2);

    protected final int mValue;

    RecorderState(int i) {
        this.mValue = i;
    }

    public static RecorderState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Closed;
        }
        if (i == 1) {
            return Paused;
        }
        if (i == 2) {
            return Running;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for RecorderState");
    }

    protected static RecorderState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        RecorderState[] recorderStateArr = new RecorderState[length];
        for (int i = 0; i < length; i++) {
            recorderStateArr[i] = fromInt(iArr[i]);
        }
        return recorderStateArr;
    }

    protected static int[] toIntArray(RecorderState[] recorderStateArr) throws RuntimeException {
        int length = recorderStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = recorderStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
