package org.linphone.core;

/* loaded from: classes3.dex */
public enum ChatRoomEphemeralMode {
    DeviceManaged(0),
    AdminManaged(1);

    protected final int mValue;

    ChatRoomEphemeralMode(int i) {
        this.mValue = i;
    }

    public static ChatRoomEphemeralMode fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return DeviceManaged;
        }
        if (i == 1) {
            return AdminManaged;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ChatRoomEphemeralMode");
    }

    protected static ChatRoomEphemeralMode[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ChatRoomEphemeralMode[] chatRoomEphemeralModeArr = new ChatRoomEphemeralMode[length];
        for (int i = 0; i < length; i++) {
            chatRoomEphemeralModeArr[i] = fromInt(iArr[i]);
        }
        return chatRoomEphemeralModeArr;
    }

    protected static int[] toIntArray(ChatRoomEphemeralMode[] chatRoomEphemeralModeArr) throws RuntimeException {
        int length = chatRoomEphemeralModeArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = chatRoomEphemeralModeArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
