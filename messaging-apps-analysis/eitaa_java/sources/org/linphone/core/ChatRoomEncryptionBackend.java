package org.linphone.core;

/* loaded from: classes3.dex */
public enum ChatRoomEncryptionBackend {
    None(0),
    Lime(1);

    protected final int mValue;

    ChatRoomEncryptionBackend(int i) {
        this.mValue = i;
    }

    public static ChatRoomEncryptionBackend fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Lime;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ChatRoomEncryptionBackend");
    }

    protected static ChatRoomEncryptionBackend[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ChatRoomEncryptionBackend[] chatRoomEncryptionBackendArr = new ChatRoomEncryptionBackend[length];
        for (int i = 0; i < length; i++) {
            chatRoomEncryptionBackendArr[i] = fromInt(iArr[i]);
        }
        return chatRoomEncryptionBackendArr;
    }

    protected static int[] toIntArray(ChatRoomEncryptionBackend[] chatRoomEncryptionBackendArr) throws RuntimeException {
        int length = chatRoomEncryptionBackendArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = chatRoomEncryptionBackendArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
