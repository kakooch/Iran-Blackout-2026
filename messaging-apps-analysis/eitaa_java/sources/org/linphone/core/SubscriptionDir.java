package org.linphone.core;

/* loaded from: classes3.dex */
public enum SubscriptionDir {
    Incoming(0),
    Outgoing(1),
    InvalidDir(2);

    protected final int mValue;

    SubscriptionDir(int i) {
        this.mValue = i;
    }

    public static SubscriptionDir fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Incoming;
        }
        if (i == 1) {
            return Outgoing;
        }
        if (i == 2) {
            return InvalidDir;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for SubscriptionDir");
    }

    protected static SubscriptionDir[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SubscriptionDir[] subscriptionDirArr = new SubscriptionDir[length];
        for (int i = 0; i < length; i++) {
            subscriptionDirArr[i] = fromInt(iArr[i]);
        }
        return subscriptionDirArr;
    }

    protected static int[] toIntArray(SubscriptionDir[] subscriptionDirArr) throws RuntimeException {
        int length = subscriptionDirArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = subscriptionDirArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
