package org.linphone.core;

/* loaded from: classes3.dex */
public enum ParticipantDeviceDisconnectionMethod {
    Booted(0),
    Departed(1),
    Busy(2),
    Failed(3);

    protected final int mValue;

    ParticipantDeviceDisconnectionMethod(int i) {
        this.mValue = i;
    }

    public static ParticipantDeviceDisconnectionMethod fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Booted;
        }
        if (i == 1) {
            return Departed;
        }
        if (i == 2) {
            return Busy;
        }
        if (i == 3) {
            return Failed;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ParticipantDeviceDisconnectionMethod");
    }

    protected static ParticipantDeviceDisconnectionMethod[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ParticipantDeviceDisconnectionMethod[] participantDeviceDisconnectionMethodArr = new ParticipantDeviceDisconnectionMethod[length];
        for (int i = 0; i < length; i++) {
            participantDeviceDisconnectionMethodArr[i] = fromInt(iArr[i]);
        }
        return participantDeviceDisconnectionMethodArr;
    }

    protected static int[] toIntArray(ParticipantDeviceDisconnectionMethod[] participantDeviceDisconnectionMethodArr) throws RuntimeException {
        int length = participantDeviceDisconnectionMethodArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = participantDeviceDisconnectionMethodArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
