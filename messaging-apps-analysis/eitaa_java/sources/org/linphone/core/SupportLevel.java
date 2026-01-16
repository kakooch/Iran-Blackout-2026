package org.linphone.core;

/* loaded from: classes3.dex */
public enum SupportLevel {
    NoSupport(0),
    Optional(1),
    Mandatory(2);

    protected final int mValue;

    SupportLevel(int i) {
        this.mValue = i;
    }

    public static SupportLevel fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return NoSupport;
        }
        if (i == 1) {
            return Optional;
        }
        if (i == 2) {
            return Mandatory;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for SupportLevel");
    }

    protected static SupportLevel[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SupportLevel[] supportLevelArr = new SupportLevel[length];
        for (int i = 0; i < length; i++) {
            supportLevelArr[i] = fromInt(iArr[i]);
        }
        return supportLevelArr;
    }

    protected static int[] toIntArray(SupportLevel[] supportLevelArr) throws RuntimeException {
        int length = supportLevelArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = supportLevelArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
