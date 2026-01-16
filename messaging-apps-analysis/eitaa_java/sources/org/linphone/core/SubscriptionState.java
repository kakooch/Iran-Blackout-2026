package org.linphone.core;

/* loaded from: classes3.dex */
public enum SubscriptionState {
    None(0),
    OutgoingProgress(1),
    IncomingReceived(2),
    Pending(3),
    Active(4),
    Terminated(5),
    Error(6),
    Expiring(7);

    protected final int mValue;

    SubscriptionState(int i) {
        this.mValue = i;
    }

    public static SubscriptionState fromInt(int i) throws RuntimeException {
        switch (i) {
            case 0:
                return None;
            case 1:
                return OutgoingProgress;
            case 2:
                return IncomingReceived;
            case 3:
                return Pending;
            case 4:
                return Active;
            case 5:
                return Terminated;
            case 6:
                return Error;
            case 7:
                return Expiring;
            default:
                throw new RuntimeException("Unhandled enum value " + i + " for SubscriptionState");
        }
    }

    protected static SubscriptionState[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SubscriptionState[] subscriptionStateArr = new SubscriptionState[length];
        for (int i = 0; i < length; i++) {
            subscriptionStateArr[i] = fromInt(iArr[i]);
        }
        return subscriptionStateArr;
    }

    protected static int[] toIntArray(SubscriptionState[] subscriptionStateArr) throws RuntimeException {
        int length = subscriptionStateArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = subscriptionStateArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
