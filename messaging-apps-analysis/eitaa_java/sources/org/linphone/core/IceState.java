package org.linphone.core;

/* loaded from: classes3.dex */
public enum IceState {
    NotActivated(0),
    Failed(1),
    InProgress(2),
    HostConnection(3),
    ReflexiveConnection(4),
    RelayConnection(5);

    protected final int mValue;

    IceState(int i) {
        this.mValue = i;
    }

    public static IceState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return NotActivated;
        }
        if (i == 1) {
            return Failed;
        }
        if (i == 2) {
            return InProgress;
        }
        if (i == 3) {
            return HostConnection;
        }
        if (i == 4) {
            return ReflexiveConnection;
        }
        if (i == 5) {
            return RelayConnection;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for IceState");
    }

    protected static IceState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        IceState[] iceStateArr = new IceState[length];
        for (int i = 0; i < length; i++) {
            iceStateArr[i] = fromInt(iArr[i]);
        }
        return iceStateArr;
    }

    protected static int[] toIntArray(IceState[] iceStateArr) throws RuntimeException {
        int length = iceStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = iceStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
