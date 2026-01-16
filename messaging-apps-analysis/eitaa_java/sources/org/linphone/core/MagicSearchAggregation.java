package org.linphone.core;

/* loaded from: classes3.dex */
public enum MagicSearchAggregation {
    None(0),
    Friend(1);

    protected final int mValue;

    MagicSearchAggregation(int i) {
        this.mValue = i;
    }

    public static MagicSearchAggregation fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Friend;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for MagicSearchAggregation");
    }

    protected static MagicSearchAggregation[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        MagicSearchAggregation[] magicSearchAggregationArr = new MagicSearchAggregation[length];
        for (int i = 0; i < length; i++) {
            magicSearchAggregationArr[i] = fromInt(iArr[i]);
        }
        return magicSearchAggregationArr;
    }

    protected static int[] toIntArray(MagicSearchAggregation[] magicSearchAggregationArr) throws RuntimeException {
        int length = magicSearchAggregationArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = magicSearchAggregationArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
