package org.linphone.core;

/* loaded from: classes3.dex */
public enum AuthMethod {
    HttpDigest(0),
    Tls(1);

    protected final int mValue;

    AuthMethod(int i) {
        this.mValue = i;
    }

    public static AuthMethod fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return HttpDigest;
        }
        if (i == 1) {
            return Tls;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for AuthMethod");
    }

    protected static AuthMethod[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        AuthMethod[] authMethodArr = new AuthMethod[length];
        for (int i = 0; i < length; i++) {
            authMethodArr[i] = fromInt(iArr[i]);
        }
        return authMethodArr;
    }

    protected static int[] toIntArray(AuthMethod[] authMethodArr) throws RuntimeException {
        int length = authMethodArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = authMethodArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
