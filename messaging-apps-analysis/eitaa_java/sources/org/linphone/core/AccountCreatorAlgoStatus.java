package org.linphone.core;

/* loaded from: classes3.dex */
public enum AccountCreatorAlgoStatus {
    Ok(0),
    NotSupported(1);

    protected final int mValue;

    AccountCreatorAlgoStatus(int i) {
        this.mValue = i;
    }

    public static AccountCreatorAlgoStatus fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Ok;
        }
        if (i == 1) {
            return NotSupported;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for AccountCreatorAlgoStatus");
    }

    protected static AccountCreatorAlgoStatus[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        AccountCreatorAlgoStatus[] accountCreatorAlgoStatusArr = new AccountCreatorAlgoStatus[length];
        for (int i = 0; i < length; i++) {
            accountCreatorAlgoStatusArr[i] = fromInt(iArr[i]);
        }
        return accountCreatorAlgoStatusArr;
    }

    protected static int[] toIntArray(AccountCreatorAlgoStatus[] accountCreatorAlgoStatusArr) throws RuntimeException {
        int length = accountCreatorAlgoStatusArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = accountCreatorAlgoStatusArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
