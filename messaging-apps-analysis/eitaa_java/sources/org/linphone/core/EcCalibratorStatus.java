package org.linphone.core;

/* loaded from: classes3.dex */
public enum EcCalibratorStatus {
    InProgress(0),
    Done(1),
    Failed(2),
    DoneNoEcho(3);

    protected final int mValue;

    EcCalibratorStatus(int i) {
        this.mValue = i;
    }

    public static EcCalibratorStatus fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return InProgress;
        }
        if (i == 1) {
            return Done;
        }
        if (i == 2) {
            return Failed;
        }
        if (i == 3) {
            return DoneNoEcho;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for EcCalibratorStatus");
    }

    protected static EcCalibratorStatus[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        EcCalibratorStatus[] ecCalibratorStatusArr = new EcCalibratorStatus[length];
        for (int i = 0; i < length; i++) {
            ecCalibratorStatusArr[i] = fromInt(iArr[i]);
        }
        return ecCalibratorStatusArr;
    }

    protected static int[] toIntArray(EcCalibratorStatus[] ecCalibratorStatusArr) throws RuntimeException {
        int length = ecCalibratorStatusArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ecCalibratorStatusArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
