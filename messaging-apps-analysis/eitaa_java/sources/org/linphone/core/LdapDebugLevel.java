package org.linphone.core;

/* loaded from: classes3.dex */
public enum LdapDebugLevel {
    Off(0),
    Verbose(1);

    protected final int mValue;

    LdapDebugLevel(int i) {
        this.mValue = i;
    }

    public static LdapDebugLevel fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Off;
        }
        if (i == 1) {
            return Verbose;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LdapDebugLevel");
    }

    protected static LdapDebugLevel[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LdapDebugLevel[] ldapDebugLevelArr = new LdapDebugLevel[length];
        for (int i = 0; i < length; i++) {
            ldapDebugLevelArr[i] = fromInt(iArr[i]);
        }
        return ldapDebugLevelArr;
    }

    protected static int[] toIntArray(LdapDebugLevel[] ldapDebugLevelArr) throws RuntimeException {
        int length = ldapDebugLevelArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ldapDebugLevelArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
