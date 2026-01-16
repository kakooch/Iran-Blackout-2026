package org.linphone.core;

/* loaded from: classes3.dex */
public enum SessionExpiresRefresher {
    Unspecified(0),
    UAS(1),
    UAC(2);

    protected final int mValue;

    SessionExpiresRefresher(int i) {
        this.mValue = i;
    }

    public static SessionExpiresRefresher fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Unspecified;
        }
        if (i == 1) {
            return UAS;
        }
        if (i == 2) {
            return UAC;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for SessionExpiresRefresher");
    }

    protected static SessionExpiresRefresher[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SessionExpiresRefresher[] sessionExpiresRefresherArr = new SessionExpiresRefresher[length];
        for (int i = 0; i < length; i++) {
            sessionExpiresRefresherArr[i] = fromInt(iArr[i]);
        }
        return sessionExpiresRefresherArr;
    }

    protected static int[] toIntArray(SessionExpiresRefresher[] sessionExpiresRefresherArr) throws RuntimeException {
        int length = sessionExpiresRefresherArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = sessionExpiresRefresherArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
