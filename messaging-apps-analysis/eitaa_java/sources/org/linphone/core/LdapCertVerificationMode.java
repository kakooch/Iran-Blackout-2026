package org.linphone.core;

/* loaded from: classes3.dex */
public enum LdapCertVerificationMode {
    Default(-1),
    Disabled(0),
    Enabled(1);

    protected final int mValue;

    LdapCertVerificationMode(int i) {
        this.mValue = i;
    }

    public static LdapCertVerificationMode fromInt(int i) throws RuntimeException {
        if (i == -1) {
            return Default;
        }
        if (i == 0) {
            return Disabled;
        }
        if (i == 1) {
            return Enabled;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LdapCertVerificationMode");
    }

    protected static LdapCertVerificationMode[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LdapCertVerificationMode[] ldapCertVerificationModeArr = new LdapCertVerificationMode[length];
        for (int i = 0; i < length; i++) {
            ldapCertVerificationModeArr[i] = fromInt(iArr[i]);
        }
        return ldapCertVerificationModeArr;
    }

    protected static int[] toIntArray(LdapCertVerificationMode[] ldapCertVerificationModeArr) throws RuntimeException {
        int length = ldapCertVerificationModeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ldapCertVerificationModeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
