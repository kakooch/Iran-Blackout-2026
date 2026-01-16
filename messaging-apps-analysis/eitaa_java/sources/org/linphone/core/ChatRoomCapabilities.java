package org.linphone.core;

/* loaded from: classes3.dex */
public enum ChatRoomCapabilities {
    None(0),
    Basic(1),
    RealTimeText(2),
    Conference(4),
    Proxy(8),
    Migratable(16),
    OneToOne(32),
    Encrypted(64),
    Ephemeral(128);

    protected final int mValue;

    ChatRoomCapabilities(int i) {
        this.mValue = i;
    }

    public static ChatRoomCapabilities fromInt(int i) throws RuntimeException {
        if (i == 0) {
            return None;
        }
        if (i == 1) {
            return Basic;
        }
        if (i == 2) {
            return RealTimeText;
        }
        if (i == 4) {
            return Conference;
        }
        if (i == 8) {
            return Proxy;
        }
        if (i == 16) {
            return Migratable;
        }
        if (i == 32) {
            return OneToOne;
        }
        if (i == 64) {
            return Encrypted;
        }
        if (i == 128) {
            return Ephemeral;
        }
        throw new RuntimeException("Unhandled enum value " + i + " for ChatRoomCapabilities");
    }

    protected static ChatRoomCapabilities[] fromIntArray(int[] iArr) throws RuntimeException {
        int length = iArr.length;
        ChatRoomCapabilities[] chatRoomCapabilitiesArr = new ChatRoomCapabilities[length];
        for (int i = 0; i < length; i++) {
            chatRoomCapabilitiesArr[i] = fromInt(iArr[i]);
        }
        return chatRoomCapabilitiesArr;
    }

    protected static int[] toIntArray(ChatRoomCapabilities[] chatRoomCapabilitiesArr) throws RuntimeException {
        int length = chatRoomCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = chatRoomCapabilitiesArr[i].toInt();
        }
        return iArr;
    }

    public int toInt() {
        return this.mValue;
    }
}
