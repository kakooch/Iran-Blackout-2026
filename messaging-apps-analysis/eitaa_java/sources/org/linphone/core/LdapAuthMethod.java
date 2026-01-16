package org.linphone.core;

/* loaded from: classes3.dex */
public enum LdapAuthMethod {
    Anonymous(0),
    Simple(1);

    protected final int mValue;

    LdapAuthMethod(int i) {
        this.mValue = i;
    }

    public static LdapAuthMethod fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Anonymous;
        }
        if (i == 1) {
            return Simple;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LdapAuthMethod");
    }

    protected static LdapAuthMethod[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LdapAuthMethod[] ldapAuthMethodArr = new LdapAuthMethod[length];
        for (int i = 0; i < length; i++) {
            ldapAuthMethodArr[i] = fromInt(iArr[i]);
        }
        return ldapAuthMethodArr;
    }

    protected static int[] toIntArray(LdapAuthMethod[] ldapAuthMethodArr) throws RuntimeException {
        int length = ldapAuthMethodArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ldapAuthMethodArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
