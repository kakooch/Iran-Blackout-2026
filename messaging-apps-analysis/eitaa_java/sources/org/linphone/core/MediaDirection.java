package org.linphone.core;

/* loaded from: classes3.dex */
public enum MediaDirection {
    Invalid(-1),
    Inactive(0),
    SendOnly(1),
    RecvOnly(2),
    SendRecv(3);

    protected final int mValue;

    MediaDirection(int i) {
        this.mValue = i;
    }

    public static MediaDirection fromInt(int i) throws RuntimeException {
        if (i == -1) {
            return Invalid;
        }
        if (i == 0) {
            return Inactive;
        }
        if (i == 1) {
            return SendOnly;
        }
        if (i == 2) {
            return RecvOnly;
        }
        if (i == 3) {
            return SendRecv;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for MediaDirection");
    }

    protected static MediaDirection[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        MediaDirection[] mediaDirectionArr = new MediaDirection[length];
        for (int i = 0; i < length; i++) {
            mediaDirectionArr[i] = fromInt(iArr[i]);
        }
        return mediaDirectionArr;
    }

    protected static int[] toIntArray(MediaDirection[] mediaDirectionArr) throws RuntimeException {
        int length = mediaDirectionArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = mediaDirectionArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
