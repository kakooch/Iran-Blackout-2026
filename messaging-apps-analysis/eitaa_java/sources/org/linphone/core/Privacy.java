package org.linphone.core;

/* loaded from: classes3.dex */
public enum Privacy {
    None(0),
    User(1),
    Header(2),
    Session(4),
    Id(8),
    Critical(16),
    Default(32768);

    protected final int mValue;

    Privacy(int i) {
        this.mValue = i;
    }

    public static Privacy fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return User;
        }
        if (i == 2) {
            return Header;
        }
        if (i == 4) {
            return Session;
        }
        if (i == 8) {
            return Id;
        }
        if (i == 16) {
            return Critical;
        }
        if (i == 32768) {
            return Default;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for Privacy");
    }

    protected static Privacy[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        Privacy[] privacyArr = new Privacy[length];
        for (int i = 0; i < length; i++) {
            privacyArr[i] = fromInt(iArr[i]);
        }
        return privacyArr;
    }

    protected static int[] toIntArray(Privacy[] privacyArr) throws RuntimeException {
        int length = privacyArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = privacyArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
