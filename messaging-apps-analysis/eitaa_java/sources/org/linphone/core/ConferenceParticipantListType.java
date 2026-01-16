package org.linphone.core;

/* loaded from: classes3.dex */
public enum ConferenceParticipantListType {
    Closed(0),
    Open(1);

    protected final int mValue;

    ConferenceParticipantListType(int i) {
        this.mValue = i;
    }

    public static ConferenceParticipantListType fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Closed;
        }
        if (i == 1) {
            return Open;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ConferenceParticipantListType");
    }

    protected static ConferenceParticipantListType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ConferenceParticipantListType[] conferenceParticipantListTypeArr = new ConferenceParticipantListType[length];
        for (int i = 0; i < length; i++) {
            conferenceParticipantListTypeArr[i] = fromInt(iArr[i]);
        }
        return conferenceParticipantListTypeArr;
    }

    protected static int[] toIntArray(ConferenceParticipantListType[] conferenceParticipantListTypeArr) throws RuntimeException {
        int length = conferenceParticipantListTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = conferenceParticipantListTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
