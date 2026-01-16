package org.linphone.core;

/* loaded from: classes3.dex */
public enum RegistrationState {
    None(0),
    Progress(1),
    Ok(2),
    Cleared(3),
    Failed(4),
    Refreshing(5);

    protected final int mValue;

    RegistrationState(int i) {
        this.mValue = i;
    }

    public static RegistrationState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Progress;
        }
        if (i == 2) {
            return Ok;
        }
        if (i == 3) {
            return Cleared;
        }
        if (i == 4) {
            return Failed;
        }
        if (i == 5) {
            return Refreshing;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for RegistrationState");
    }

    protected static RegistrationState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        RegistrationState[] registrationStateArr = new RegistrationState[length];
        for (int i = 0; i < length; i++) {
            registrationStateArr[i] = fromInt(iArr[i]);
        }
        return registrationStateArr;
    }

    protected static int[] toIntArray(RegistrationState[] registrationStateArr) throws RuntimeException {
        int length = registrationStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = registrationStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
