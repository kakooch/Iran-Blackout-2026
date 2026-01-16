package org.linphone.core;

/* loaded from: classes3.dex */
public enum LdapCheck {
    Ok(0),
    ServerEmpty(1),
    ServerNotUrl(2),
    ServerNoScheme(4),
    ServerNotLdap(8),
    ServerLdaps(16),
    BaseObjectEmpty(32),
    MissingFields(64);

    protected final int mValue;

    LdapCheck(int i) {
        this.mValue = i;
    }

    public static LdapCheck fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Ok;
        }
        if (i == 1) {
            return ServerEmpty;
        }
        if (i == 2) {
            return ServerNotUrl;
        }
        if (i == 4) {
            return ServerNoScheme;
        }
        if (i == 8) {
            return ServerNotLdap;
        }
        if (i == 16) {
            return ServerLdaps;
        }
        if (i == 32) {
            return BaseObjectEmpty;
        }
        if (i == 64) {
            return MissingFields;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LdapCheck");
    }

    protected static LdapCheck[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LdapCheck[] ldapCheckArr = new LdapCheck[length];
        for (int i = 0; i < length; i++) {
            ldapCheckArr[i] = fromInt(iArr[i]);
        }
        return ldapCheckArr;
    }

    protected static int[] toIntArray(LdapCheck[] ldapCheckArr) throws RuntimeException {
        int length = ldapCheckArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = ldapCheckArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
