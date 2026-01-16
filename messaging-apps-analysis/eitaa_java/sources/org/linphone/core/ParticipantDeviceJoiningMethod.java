package org.linphone.core;

/* loaded from: classes3.dex */
public enum ParticipantDeviceJoiningMethod {
    DialedIn(0),
    DialedOut(1),
    FocusOwner(2);

    protected final int mValue;

    ParticipantDeviceJoiningMethod(int i) {
        this.mValue = i;
    }

    public static ParticipantDeviceJoiningMethod fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return DialedIn;
        }
        if (i == 1) {
            return DialedOut;
        }
        if (i == 2) {
            return FocusOwner;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ParticipantDeviceJoiningMethod");
    }

    protected static ParticipantDeviceJoiningMethod[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ParticipantDeviceJoiningMethod[] participantDeviceJoiningMethodArr = new ParticipantDeviceJoiningMethod[length];
        for (int i = 0; i < length; i++) {
            participantDeviceJoiningMethodArr[i] = fromInt(iArr[i]);
        }
        return participantDeviceJoiningMethodArr;
    }

    protected static int[] toIntArray(ParticipantDeviceJoiningMethod[] participantDeviceJoiningMethodArr) throws RuntimeException {
        int length = participantDeviceJoiningMethodArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = participantDeviceJoiningMethodArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
