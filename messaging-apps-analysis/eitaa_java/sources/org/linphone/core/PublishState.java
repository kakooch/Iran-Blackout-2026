package org.linphone.core;

/* loaded from: classes3.dex */
public enum PublishState {
    None(0),
    Progress(1),
    Ok(2),
    Error(3),
    Expiring(4),
    Cleared(5);

    protected final int mValue;

    PublishState(int i) {
        this.mValue = i;
    }

    public static PublishState fromInt(int i) throws RuntimeException {
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
            return Error;
        }
        if (i == 4) {
            return Expiring;
        }
        if (i == 5) {
            return Cleared;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for PublishState");
    }

    protected static PublishState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        PublishState[] publishStateArr = new PublishState[length];
        for (int i = 0; i < length; i++) {
            publishStateArr[i] = fromInt(iArr[i]);
        }
        return publishStateArr;
    }

    protected static int[] toIntArray(PublishState[] publishStateArr) throws RuntimeException {
        int length = publishStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = publishStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
