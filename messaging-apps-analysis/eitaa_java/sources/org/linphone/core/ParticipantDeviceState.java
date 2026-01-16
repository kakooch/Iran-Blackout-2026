package org.linphone.core;

/* loaded from: classes3.dex */
public enum ParticipantDeviceState {
    Joining(0),
    Present(1),
    Leaving(2),
    Left(3),
    ScheduledForJoining(4),
    ScheduledForLeaving(5),
    OnHold(6),
    Alerting(7),
    MutedByFocus(8);

    protected final int mValue;

    ParticipantDeviceState(int i) {
        this.mValue = i;
    }

    public static ParticipantDeviceState fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return Joining;
            case 1:
                return Present;
            case 2:
                return Leaving;
            case 3:
                return Left;
            case 4:
                return ScheduledForJoining;
            case 5:
                return ScheduledForLeaving;
            case 6:
                return OnHold;
            case 7:
                return Alerting;
            case 8:
                return MutedByFocus;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for ParticipantDeviceState");
        }
    }

    protected static ParticipantDeviceState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ParticipantDeviceState[] participantDeviceStateArr = new ParticipantDeviceState[length];
        for (int i = 0; i < length; i++) {
            participantDeviceStateArr[i] = fromInt(iArr[i]);
        }
        return participantDeviceStateArr;
    }

    protected static int[] toIntArray(ParticipantDeviceState[] participantDeviceStateArr) throws RuntimeException {
        int length = participantDeviceStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = participantDeviceStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
