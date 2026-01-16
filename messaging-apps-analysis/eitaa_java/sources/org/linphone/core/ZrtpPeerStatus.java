package org.linphone.core;

/* loaded from: classes3.dex */
public enum ZrtpPeerStatus {
    Unknown(0),
    Invalid(1),
    Valid(2);

    protected final int mValue;

    ZrtpPeerStatus(int i) {
        this.mValue = i;
    }

    public static ZrtpPeerStatus fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Unknown;
        }
        if (i == 1) {
            return Invalid;
        }
        if (i == 2) {
            return Valid;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ZrtpPeerStatus");
    }

    protected static ZrtpPeerStatus[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ZrtpPeerStatus[] zrtpPeerStatusArr = new ZrtpPeerStatus[length];
        for (int i = 0; i < length; i++) {
            zrtpPeerStatusArr[i] = fromInt(iArr[i]);
        }
        return zrtpPeerStatusArr;
    }

    protected static int[] toIntArray(ZrtpPeerStatus[] zrtpPeerStatusArr) throws RuntimeException {
        int length = zrtpPeerStatusArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = zrtpPeerStatusArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
