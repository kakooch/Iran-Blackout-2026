package org.linphone.core;

/* loaded from: classes3.dex */
public enum PresenceBasicStatus {
    Open(0),
    Closed(1);

    protected final int mValue;

    PresenceBasicStatus(int i) {
        this.mValue = i;
    }

    public static PresenceBasicStatus fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Open;
        }
        if (i == 1) {
            return Closed;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for PresenceBasicStatus");
    }

    protected static PresenceBasicStatus[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        PresenceBasicStatus[] presenceBasicStatusArr = new PresenceBasicStatus[length];
        for (int i = 0; i < length; i++) {
            presenceBasicStatusArr[i] = fromInt(iArr[i]);
        }
        return presenceBasicStatusArr;
    }

    protected static int[] toIntArray(PresenceBasicStatus[] presenceBasicStatusArr) throws RuntimeException {
        int length = presenceBasicStatusArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = presenceBasicStatusArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
