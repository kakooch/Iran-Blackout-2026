package org.linphone.core;

/* loaded from: classes3.dex */
public enum AccountCreatorBackend {
    XMLRPC(0),
    FlexiAPI(1);

    protected final int mValue;

    AccountCreatorBackend(int i) {
        this.mValue = i;
    }

    public static AccountCreatorBackend fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return XMLRPC;
        }
        if (i == 1) {
            return FlexiAPI;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for AccountCreatorBackend");
    }

    protected static AccountCreatorBackend[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        AccountCreatorBackend[] accountCreatorBackendArr = new AccountCreatorBackend[length];
        for (int i = 0; i < length; i++) {
            accountCreatorBackendArr[i] = fromInt(iArr[i]);
        }
        return accountCreatorBackendArr;
    }

    protected static int[] toIntArray(AccountCreatorBackend[] accountCreatorBackendArr) throws RuntimeException {
        int length = accountCreatorBackendArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = accountCreatorBackendArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
