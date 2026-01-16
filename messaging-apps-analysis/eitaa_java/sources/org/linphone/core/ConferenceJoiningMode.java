package org.linphone.core;

/* loaded from: classes3.dex */
public enum ConferenceJoiningMode {
    DialIn(0),
    DialOut(1);

    protected final int mValue;

    ConferenceJoiningMode(int i) {
        this.mValue = i;
    }

    public static ConferenceJoiningMode fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return DialIn;
        }
        if (i == 1) {
            return DialOut;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ConferenceJoiningMode");
    }

    protected static ConferenceJoiningMode[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ConferenceJoiningMode[] conferenceJoiningModeArr = new ConferenceJoiningMode[length];
        for (int i = 0; i < length; i++) {
            conferenceJoiningModeArr[i] = fromInt(iArr[i]);
        }
        return conferenceJoiningModeArr;
    }

    protected static int[] toIntArray(ConferenceJoiningMode[] conferenceJoiningModeArr) throws RuntimeException {
        int length = conferenceJoiningModeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = conferenceJoiningModeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
