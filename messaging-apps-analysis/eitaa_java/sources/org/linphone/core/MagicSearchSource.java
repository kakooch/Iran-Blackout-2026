package org.linphone.core;

/* loaded from: classes3.dex */
public enum MagicSearchSource {
    None(0),
    Friends(1),
    CallLogs(2),
    LdapServers(4),
    ChatRooms(8),
    Request(16),
    FavoriteFriends(32),
    All(-1);

    protected final int mValue;

    MagicSearchSource(int i) {
        this.mValue = i;
    }

    public static MagicSearchSource fromInt(int i) throws RuntimeException {
        if (i == -1) {
            return All;
        }
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Friends;
        }
        if (i == 2) {
            return CallLogs;
        }
        if (i == 4) {
            return LdapServers;
        }
        if (i == 8) {
            return ChatRooms;
        }
        if (i == 16) {
            return Request;
        }
        if (i == 32) {
            return FavoriteFriends;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for MagicSearchSource");
    }

    protected static MagicSearchSource[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        MagicSearchSource[] magicSearchSourceArr = new MagicSearchSource[length];
        for (int i = 0; i < length; i++) {
            magicSearchSourceArr[i] = fromInt(iArr[i]);
        }
        return magicSearchSourceArr;
    }

    protected static int[] toIntArray(MagicSearchSource[] magicSearchSourceArr) throws RuntimeException {
        int length = magicSearchSourceArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = magicSearchSourceArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
