package org.linphone.core;

/* loaded from: classes3.dex */
public enum MediaEncryption {
    None(0),
    SRTP(1),
    ZRTP(2),
    DTLS(3);

    protected final int mValue;

    MediaEncryption(int i) {
        this.mValue = i;
    }

    public static MediaEncryption fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return SRTP;
        }
        if (i == 2) {
            return ZRTP;
        }
        if (i == 3) {
            return DTLS;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for MediaEncryption");
    }

    protected static MediaEncryption[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        MediaEncryption[] mediaEncryptionArr = new MediaEncryption[length];
        for (int i = 0; i < length; i++) {
            mediaEncryptionArr[i] = fromInt(iArr[i]);
        }
        return mediaEncryptionArr;
    }

    protected static int[] toIntArray(MediaEncryption[] mediaEncryptionArr) throws RuntimeException {
        int length = mediaEncryptionArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = mediaEncryptionArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
