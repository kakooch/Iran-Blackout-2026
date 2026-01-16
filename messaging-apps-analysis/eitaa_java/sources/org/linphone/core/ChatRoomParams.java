package org.linphone.core;

/* loaded from: classes3.dex */
public interface ChatRoomParams {
    ChatRoomBackend getBackend();

    ChatRoomEncryptionBackend getEncryptionBackend();

    long getEphemeralLifetime();

    ChatRoomEphemeralMode getEphemeralMode();

    long getNativePointer();

    String getSubject();

    Object getUserData();

    boolean isEncryptionEnabled();

    boolean isGroupEnabled();

    boolean isRttEnabled();

    boolean isValid();

    void setBackend(ChatRoomBackend chatRoomBackend);

    void setEncryptionBackend(ChatRoomEncryptionBackend chatRoomEncryptionBackend);

    void setEncryptionEnabled(boolean z);

    void setEphemeralLifetime(long j);

    void setEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode);

    void setGroupEnabled(boolean z);

    void setRttEnabled(boolean z);

    void setSubject(String str);

    void setUserData(Object obj);

    String toString();
}
