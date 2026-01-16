package org.linphone.core;

/* loaded from: classes3.dex */
public enum FriendCapability {
    None(0),
    GroupChat(1),
    LimeX3Dh(2),
    EphemeralMessages(4);

    protected final int mValue;

    FriendCapability(int i) {
        this.mValue = i;
    }

    public static FriendCapability fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return GroupChat;
        }
        if (i == 2) {
            return LimeX3Dh;
        }
        if (i == 4) {
            return EphemeralMessages;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for FriendCapability");
    }

    protected static FriendCapability[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        FriendCapability[] friendCapabilityArr = new FriendCapability[length];
        for (int i = 0; i < length; i++) {
            friendCapabilityArr[i] = fromInt(iArr[i]);
        }
        return friendCapabilityArr;
    }

    protected static int[] toIntArray(FriendCapability[] friendCapabilityArr) throws RuntimeException {
        int length = friendCapabilityArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = friendCapabilityArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
