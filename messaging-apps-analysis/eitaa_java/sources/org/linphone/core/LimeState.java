package org.linphone.core;

/* loaded from: classes3.dex */
public enum LimeState {
    Disabled(0),
    Mandatory(1),
    Preferred(2);

    protected final int mValue;

    LimeState(int i) {
        this.mValue = i;
    }

    public static LimeState fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Disabled;
        }
        if (i == 1) {
            return Mandatory;
        }
        if (i == 2) {
            return Preferred;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for LimeState");
    }

    protected static LimeState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        LimeState[] limeStateArr = new LimeState[length];
        for (int i = 0; i < length; i++) {
            limeStateArr[i] = fromInt(iArr[i]);
        }
        return limeStateArr;
    }

    protected static int[] toIntArray(LimeState[] limeStateArr) throws RuntimeException {
        int length = limeStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = limeStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
