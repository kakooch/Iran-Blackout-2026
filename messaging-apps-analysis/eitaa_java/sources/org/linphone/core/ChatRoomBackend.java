package org.linphone.core;

/* loaded from: classes3.dex */
public enum ChatRoomBackend {
    Basic(1),
    FlexisipChat(2);

    protected final int mValue;

    ChatRoomBackend(int i) {
        this.mValue = i;
    }

    public static ChatRoomBackend fromInt(int i) throws RuntimeException {
        if (i == 1) {
            return Basic;
        }
        if (i == 2) {
            return FlexisipChat;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ChatRoomBackend");
    }

    protected static ChatRoomBackend[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ChatRoomBackend[] chatRoomBackendArr = new ChatRoomBackend[length];
        for (int i = 0; i < length; i++) {
            chatRoomBackendArr[i] = fromInt(iArr[i]);
        }
        return chatRoomBackendArr;
    }

    protected static int[] toIntArray(ChatRoomBackend[] chatRoomBackendArr) throws RuntimeException {
        int length = chatRoomBackendArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = chatRoomBackendArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
