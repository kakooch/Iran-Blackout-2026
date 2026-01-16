package org.linphone.core;

/* loaded from: classes3.dex */
public enum FriendListType {
    Default(-1),
    CardDAV(0),
    VCard4(1);

    protected final int mValue;

    FriendListType(int i) {
        this.mValue = i;
    }

    public static FriendListType fromInt(int i) throws RuntimeException {
        if (i == -1) {
            return Default;
        }
        if (i == 0) {
            return CardDAV;
        }
        if (i == 1) {
            return VCard4;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for FriendListType");
    }

    protected static FriendListType[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        FriendListType[] friendListTypeArr = new FriendListType[length];
        for (int i = 0; i < length; i++) {
            friendListTypeArr[i] = fromInt(iArr[i]);
        }
        return friendListTypeArr;
    }

    protected static int[] toIntArray(FriendListType[] friendListTypeArr) throws RuntimeException {
        int length = friendListTypeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = friendListTypeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
