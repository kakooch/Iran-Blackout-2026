package org.linphone.core;

/* loaded from: classes3.dex */
public enum SubscribePolicy {
    SPWait(0),
    SPDeny(1),
    SPAccept(2);

    protected final int mValue;

    SubscribePolicy(int i) {
        this.mValue = i;
    }

    public static SubscribePolicy fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return SPWait;
        }
        if (i == 1) {
            return SPDeny;
        }
        if (i == 2) {
            return SPAccept;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for SubscribePolicy");
    }

    protected static SubscribePolicy[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        SubscribePolicy[] subscribePolicyArr = new SubscribePolicy[length];
        for (int i = 0; i < length; i++) {
            subscribePolicyArr[i] = fromInt(iArr[i]);
        }
        return subscribePolicyArr;
    }

    protected static int[] toIntArray(SubscribePolicy[] subscribePolicyArr) throws RuntimeException {
        int length = subscribePolicyArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = subscribePolicyArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
