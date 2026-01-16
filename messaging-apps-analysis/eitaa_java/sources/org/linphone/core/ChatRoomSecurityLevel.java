package org.linphone.core;

/* loaded from: classes3.dex */
public enum ChatRoomSecurityLevel {
    Unsafe(0),
    ClearText(1),
    Encrypted(2),
    Safe(3);

    protected final int mValue;

    ChatRoomSecurityLevel(int i) {
        this.mValue = i;
    }

    public static ChatRoomSecurityLevel fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return Unsafe;
        }
        if (i == 1) {
            return ClearText;
        }
        if (i == 2) {
            return Encrypted;
        }
        if (i == 3) {
            return Safe;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ChatRoomSecurityLevel");
    }

    protected static ChatRoomSecurityLevel[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ChatRoomSecurityLevel[] chatRoomSecurityLevelArr = new ChatRoomSecurityLevel[length];
        for (int i = 0; i < length; i++) {
            chatRoomSecurityLevelArr[i] = fromInt(iArr[i]);
        }
        return chatRoomSecurityLevelArr;
    }

    protected static int[] toIntArray(ChatRoomSecurityLevel[] chatRoomSecurityLevelArr) throws RuntimeException {
        int length = chatRoomSecurityLevelArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = chatRoomSecurityLevelArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
