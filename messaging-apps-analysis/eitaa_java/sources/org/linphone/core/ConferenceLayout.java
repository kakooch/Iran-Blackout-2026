package org.linphone.core;

/* loaded from: classes3.dex */
public enum ConferenceLayout {
    Grid(0),
    ActiveSpeaker(1);

    protected final int mValue;

    ConferenceLayout(int i) {
        this.mValue = i;
    }

    public static ConferenceLayout fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Grid;
        }
        if (i == 1) {
            return ActiveSpeaker;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ConferenceLayout");
    }

    protected static ConferenceLayout[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ConferenceLayout[] conferenceLayoutArr = new ConferenceLayout[length];
        for (int i = 0; i < length; i++) {
            conferenceLayoutArr[i] = fromInt(iArr[i]);
        }
        return conferenceLayoutArr;
    }

    protected static int[] toIntArray(ConferenceLayout[] conferenceLayoutArr) throws RuntimeException {
        int length = conferenceLayoutArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = conferenceLayoutArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
